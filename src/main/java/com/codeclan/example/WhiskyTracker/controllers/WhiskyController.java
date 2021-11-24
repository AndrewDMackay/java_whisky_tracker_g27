package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> findWhiskyFilterByYear(@RequestParam(name = "year", required = false) int year){
        return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> findWhiskiesByAgeAndDistilleryName(@RequestParam(name = "age", required = false) int age, @RequestParam(name = "name", required = false) String name){
        return new ResponseEntity<>(whiskyRepository.findWhiskiesByAgeAndDistilleryName(age, name), HttpStatus.OK);
    }
}
