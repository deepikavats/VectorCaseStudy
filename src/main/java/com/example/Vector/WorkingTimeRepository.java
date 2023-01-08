package com.example.Vector;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingTimeRepository extends CrudRepository<WorkingTimings, String> {

    WorkingTimings findByDay(String name);



}


