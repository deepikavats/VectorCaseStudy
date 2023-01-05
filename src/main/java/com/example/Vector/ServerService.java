package com.example.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class ServerService {

    @Autowired
    LicenseRepository licenseRepository;

    public Integer getLicense(String nameOfCompiler){
       License license = licenseRepository.findByCompilerName(nameOfCompiler);
       int number = license.getNumberOfLicenseInWorkingHours();
        return number;
    }

    public String reserveLicense(String nameOfCompiler){
        String result;
        License license = licenseRepository.findByCompilerName(nameOfCompiler);
        int maximumLicense = license.getNumberOfLicenseInWorkingHours();
        int currentLicense = license.getCurrentLicense();
        if(currentLicense < maximumLicense){
            currentLicense = currentLicense + 1;
            license.setCurrentLicense(currentLicense);
            licenseRepository.save(license);
            result = "Successful";
        }
        else{
            result = "Failure";
        }

        return result;
    }

    public void freeLicense(String nameOfCompiler){
        License license = licenseRepository.findByCompilerName(nameOfCompiler);
        int maximumLicense = license.getNumberOfLicenseInWorkingHours();
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
        licenseRepository.save(licenses);
        return licenses;
    }
}
