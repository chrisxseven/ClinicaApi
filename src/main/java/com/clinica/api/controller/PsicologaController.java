package com.clinica.api.controller;


import com.clinica.api.datasource.model.Psicologa;
import com.clinica.api.repository.PsicologaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class PsicologaController {

    @Autowired
    private PsicologaRepository psicologaRepository;

    @GetMapping(path = "/psicologas")
    public List<Psicologa> buscarPsicologa() {
       return psicologaRepository.findAll();
    }
    @GetMapping(path = "/psicologa/id/{id}")
    public Optional<Psicologa> buscarPsicologaPorId(
            @PathVariable (name = "id", required = true) Long id) {
       return psicologaRepository.findById(id);
    }
}
