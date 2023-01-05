package com.example.Vector;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Slf4j
@RestController
public class ServerController {

    @Autowired
    ServerService serverService;

    @GetMapping(path = "/getLicense")
    public ResponseEntity<Integer> getNumberOfLicense(@RequestParam(name = "compilerName") @NotNull String compilerName){
       int numberOfLicense= serverService.getLicense(compilerName);
       return ResponseEntity.ok(numberOfLicense);
    }

    @GetMapping(path = "/reserveLicense")
    public ResponseEntity<String> reserveLicense(@RequestParam(name = "compilerName") @NotNull String compilerName){
        String result = serverService.reserveLicense(compilerName);
        return ResponseEntity.ok(result);
    }

    @PostMapping(path = "/freeLicense")
    public ResponseEntity<String> freeLicense(@RequestParam(name = "compilerName") @NotNull String compilerName){
        serverService.freeLicense(compilerName);
        return new ResponseEntity<>("License has been released", HttpStatus.OK);
    }

    @PostMapping(path = "/configurelicenses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<License> configureLicense(@RequestParam(name = "compilerName") @NotNull String compilerName, @RequestParam(name = "numberOfLicenseInWorkingHours") @NotNull int numberOfLicenseInWorkingHours, @RequestParam(name = "numberOfLicenseInNonWorkingHours") @NotNull int numberOfLicenseInNonWorkingHours){
        License license1 = serverService.licenseConfiguration(compilerName, numberOfLicenseInWorkingHours, numberOfLicenseInNonWorkingHours );
        return ResponseEntity.ok(license1);

    }

}
