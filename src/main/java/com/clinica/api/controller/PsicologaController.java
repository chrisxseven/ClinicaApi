package com.clinica.api.controller;


import com.clinica.api.datasource.model.Psicologa;
import com.clinica.api.exception.PsicologaNotFoundException;
import com.clinica.api.resource.model.PsicologaResource;
import com.clinica.api.servicepsi.BuscarPsicologaPorIdService;
import com.clinica.api.servicepsi.BuscarPsicologaService;
import com.clinica.api.servicepsi.CadastroPsicologa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/psi")
public class PsicologaController {

    @Autowired
    private BuscarPsicologaService serviceBuscar;

    @Autowired
    private CadastroPsicologa serviceCadastro;

    @Autowired
    private BuscarPsicologaPorIdService serviceBuscarPorId;

    @GetMapping(path = "/psicologas")
    public List<Psicologa> buscarPsicologas() {
       return serviceBuscar.buscarTodasAsPsicologas();
    }
    @GetMapping(path = "/psicologa/id/{id}")
    public Psicologa buscarPsicologaPorId(
            @PathVariable (name = "id", required = true) Long id) throws PsicologaNotFoundException {
       return serviceBuscarPorId.buscarPorId(id);
    }

    @PostMapping(path = "psicologa/save")
    public void salvarPsicologa(@RequestBody PsicologaResource psicologa) {
        serviceCadastro.cadastro(psicologa);

    }

    @DeleteMapping(path = "psicologa/delete/{id}")
    public void deletarPsicologa(@PathVariable (name = "id", required = true) Long id) throws PsicologaNotFoundException {
        serviceBuscarPorId.deletarPorId(id);
    }
}
