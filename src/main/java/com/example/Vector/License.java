package com.example.Vector;

import jakarta.persistence.*;
import lombok.Data;

//import javax.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
@Table(name = "License")
public class License {

    @Id
    String compilerName;

    int numberOfLicense;

    int currentLicense;




}
