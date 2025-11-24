package com.example.experiment_api.controller;

import com.example.experiment_api.model.Experiment;
import com.example.experiment_api.service.ExperimentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiments")
public class ExperimentController {

    private final ExperimentService service;

    public ExperimentController(ExperimentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Experiment> create(@RequestBody Experiment experiment) {
        Experiment created = service.create(experiment);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Experiment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Experiment getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Experiment update(@PathVariable Long id, @RequestBody Experiment experiment) {
        return service.update(id, experiment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
