package com.clinica.api.controller.psicologo;


import com.clinica.api.datasource.model.Psicologa;
import com.clinica.api.exception.PsicologaNotFoundException;
import com.clinica.api.resource.model.PsicologaResource;
import com.clinica.api.service.psicologa.BuscarPsicologaPorIdService;
import com.clinica.api.service.psicologa.BuscarPsicologaService;
import com.clinica.api.service.psicologa.CadastroPsicologa;
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
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/psicologas")
    public List<Psicologa> buscarPsicologas() {
       return serviceBuscar.buscarTodasAsPsicologas();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/psicologa/id/{id}")
    public Psicologa buscarPsicologaPorId(
            @PathVariable (name = "id", required = true) Long id) throws PsicologaNotFoundException {
       return serviceBuscarPorId.buscarPorId(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/psicologa/save")
    public void salvarPsicologa(@RequestBody PsicologaResource psicologa) {
        serviceCadastro.cadastro(psicologa);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "psicologa/delete/{id}")
    public void deletarPsicologa(@PathVariable (name = "id", required = true) Long id) throws PsicologaNotFoundException {
        serviceBuscarPorId.deletarPorId(id);
    }
}
