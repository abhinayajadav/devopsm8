package com.example.experiment_api.service;

import com.example.experiment_api.model.Experiment;
import com.example.experiment_api.repository.ExperimentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperimentService {

    private final ExperimentRepository repository;

    public ExperimentService(ExperimentRepository repository) {
        this.repository = repository;
    }

    public Experiment create(Experiment experiment) {
        return repository.save(experiment);
    }

    public List<Experiment> getAll() {
        return repository.findAll();
    }

    public Experiment getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experiment not found with id " + id));
    }

    public Experiment update(Long id, Experiment updated) {
        Experiment existing = getById(id);
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setStatus(updated.getStatus());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
