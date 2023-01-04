package com.example.Vector;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@Slf4j
@RestController
public class ServerController {

    @Autowired
    ServerService serverService;

    @GetMapping(path = "/getLicense")
    public ResponseEntity<Integer> getNumberOfLicense(){
       int numberOfLicense= serverService.getLicense();
       return ResponseEntity.ok(numberOfLicense);
    }

    @GetMapping(path = "/reserveLicense")
    public ResponseEntity<String> reserveLicense(){
        String result = serverService.reserveLicense();
        return ResponseEntity.ok(result);
    }

    @PostMapping(path = "/freeLicense")
    public ResponseEntity<String> freeLicense(){
        serverService.freeLicense();
        return new ResponseEntity<>("License has been released", HttpStatus.OK);
    }

    @PostMapping(path = "/configurelicenses", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<License> configureLicense(@RequestBody @Valid License license){
        //need only two things 1. number of license 2. compiler name
        //working hours
        License license1 = serverService.licenseConfiguration(license);
        return ResponseEntity.ok(license1);

    }

}
