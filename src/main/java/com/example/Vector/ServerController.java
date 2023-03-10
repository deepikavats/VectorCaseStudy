package com.example.Vector;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        String result = serverService.freeLicense(compilerName);
        return ResponseEntity.ok(result);
    }

    @PostMapping(path = "/configurelicenses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<License> configureLicense(@RequestParam(name = "compilerName") @NotNull String compilerName, @RequestParam(name = "numberOfLicenseInWorkingHours") @NotNull int numberOfLicenseInWorkingHours, @RequestParam(name = "numberOfLicenseInNonWorkingHours") @NotNull int numberOfLicenseInNonWorkingHours){
        License license1 = serverService.licenseConfiguration(compilerName, numberOfLicenseInWorkingHours, numberOfLicenseInNonWorkingHours );
        return ResponseEntity.ok(license1);
    }

    @PostMapping(path = "/configureWorkingTimings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkingTimings> configureWorkingTimings(@Valid @RequestBody(required = true) WorkingHoursConfiguration workingTimings){
        WorkingTimings timings = serverService.workingTimeConfiguration(workingTimings);
        return ResponseEntity.ok(timings);
    }

    @GetMapping(path = "/getLicenseData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<LicenseData>> getLicenseData(){
        Iterable<LicenseData> data = serverService.getLicenseData();
        return ResponseEntity.ok(data);
    }

}
