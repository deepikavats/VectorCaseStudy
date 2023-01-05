package com.example.Vector;

import jakarta.persistence.*;
import lombok.Data;

//import javax.persistence.*;


@Data
@Entity
@Table(name = "LICENSE")
public class License {

    @Id
    @Column(name = "COMPILERNAME")
    String compilerName;

    @Column(name = "NUMBEROFLICENSEINWORKINGHOURS")
    int numberOfLicenseInWorkingHours;

    @Column(name = "NUMBEROFLICENSEINNONWORKINGHOURS")
    int numberOfLicenseInNonWorkingHours;

    @Column(name = "CURRENTLICENSE")
    int currentLicense;




}
