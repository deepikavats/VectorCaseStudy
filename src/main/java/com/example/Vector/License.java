package com.example.Vector;

import jakarta.persistence.*;
import lombok.Data;

//import javax.persistence.*;


@Data
@Entity
@Table(name = "LICENSE")
public class License {

    @Id
    @Column(name = "compilername")
    String compilerName;

    @Column(name = "numberoflicenseinworkinghours")
    int numberOfLicenseInWorkingHours;

    @Column(name = "numberoflicenseinnonworkinghours")
    int numberOfLicenseInNonWorkingHours;

    @Column(name = "currentlicense")
    int currentLicense;




}
