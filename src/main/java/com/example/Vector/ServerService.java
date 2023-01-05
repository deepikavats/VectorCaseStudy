package com.example.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerService {

    @Autowired
    LicenseRepository licenseRepository;

    public Integer getLicense(String nameOfCompiler){
       License license = licenseRepository.findByCompilerName(nameOfCompiler);
       int number = license.getNumberOfLicense();
        return number;
    }

    public String reserveLicense(String nameOfCompiler){
        String result;
        License license = licenseRepository.findByCompilerName(nameOfCompiler);
        int maximumLicense = license.getNumberOfLicense();
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
        int maximumLicense = license.getNumberOfLicense();
        int currentLicense = license.getCurrentLicense();
        currentLicense = currentLicense - 1;
        license.setCurrentLicense(currentLicense);
        licenseRepository.save(license);
    }
    public License licenseConfiguration(License license){
        License licenses = new License();
        int licenseAvailable = license.getNumberOfLicense();
        int currentLicense = license.getCurrentLicense();
        licenses.setNumberOfLicense(licenseAvailable);
        licenses.setCurrentLicense(currentLicense);
        licenseRepository.save(license);
        int LicenseNumber = licenses.getNumberOfLicense();
        System.out.println("license are-----" + LicenseNumber);
        return license;
    }
}
