package com.example.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Service
public class ServerService {

    @Autowired
    LicenseRepository licenseRepository;

    @Autowired
    WorkingTimeRepository workingTimeRepository;

    @Autowired
    LicenseDataRepository licenseDataRepository;

    public Integer getLicense(String nameOfCompiler){
       License license = licenseRepository.findByCompilerName(nameOfCompiler);
       int licenseInWorkingHours = license.getNumberOfLicenseInWorkingHours();
        return licenseInWorkingHours;
    }

    public String reserveLicense(String nameOfCompiler){
        int maxLicense;
        String result;
        License license = licenseRepository.findByCompilerName(nameOfCompiler);
        int maximumWorkingHoursLicense = license.getNumberOfLicenseInWorkingHours();
        int maximumNonWorkingHoursLicense = license.getNumberOfLicenseInNonWorkingHours();
        int currentLicense = license.getCurrentLicense();
        LocalTime currentTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();
        DayOfWeek day =currentDate.getDayOfWeek();
        String nameOfDay =day.name();
        System.out.println("Name of day------" + nameOfDay);
        WorkingTimings timings = workingTimeRepository.findByDay(nameOfDay);
        if(timings == null){
            maxLicense = maximumNonWorkingHoursLicense;
        }
        else{
            if(timings.getStartTime().isBefore(currentTime) && timings.getEndTime().isAfter(currentTime)){
                maxLicense = maximumWorkingHoursLicense;
            }
            else{
                maxLicense = maximumNonWorkingHoursLicense;
            }
        }
        if(currentLicense < maxLicense){
            currentLicense = currentLicense + 1;
            license.setCurrentLicense(currentLicense);
            licenseRepository.save(license);
            result = "Successful";
        }
        else{
            result = "Failure";
        }
        LicenseData data = licenseDataRepository.findByCompilerNameAndLicenseDate(nameOfCompiler, currentDate);
        if(data !=null){
            if(currentLicense > data.licensesUsedByCi){
                data.setLicensesUsedByCi(currentLicense);
                licenseDataRepository.save(data);
            }
        }
        else{
            data = new LicenseData();
            data.setCompilerName(nameOfCompiler);
            data.setLicenseDate(currentDate);
            data.setLicensesUsedByCi(currentLicense);
            licenseDataRepository.save(data);
        }

        return result;
    }

    public void freeLicense(String nameOfCompiler){
        License license = licenseRepository.findByCompilerName(nameOfCompiler);
        int currentLicense = license.getCurrentLicense();
        currentLicense = currentLicense - 1;
        license.setCurrentLicense(currentLicense);
        licenseRepository.save(license);
    }
    public License licenseConfiguration(@NotNull String nameOfCompiler, @NotNull int workingHoursLicense, @NotNull int nonWorkingHoursLicense){
        License licenses = new License();
        licenses.setCompilerName(nameOfCompiler);
        licenses.setNumberOfLicenseInWorkingHours(workingHoursLicense);
        licenses.setNumberOfLicenseInNonWorkingHours(nonWorkingHoursLicense);
        License license = licenseRepository.findByCompilerName(nameOfCompiler);
        int currentlicense = license.getCurrentLicense();
        licenses.setCurrentLicense(currentlicense);
        licenseRepository.save(licenses);
        return licenses;
    }

    public WorkingTimings workingTimeConfiguration(WorkingHoursConfiguration times){
        String dayName = times.getDay();
        LocalTime startTime = LocalTime.of(times.getStartHours(), times.getStartminutes());
        LocalTime endTime = LocalTime.of(times.getEndHours(), times.getEndMinutes());
        WorkingTimings timings = new WorkingTimings();
        timings.setDay(dayName);
        timings.setStartTime(startTime);
        timings.setEndTime(endTime);
        workingTimeRepository.save(timings);
        return timings;

    }

    public Iterable<LicenseData> getLicenseData(){
        Iterable<LicenseData> licenseData = licenseDataRepository.findAll();
        return licenseData;
    }
}
