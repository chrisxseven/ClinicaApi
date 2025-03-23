package com.clinica.api.controller;

import com.clinica.api.datasource.model.Paciente;
import com.clinica.api.exception.PacienteNotFoundException;
import com.clinica.api.exception.PsicologaNotFoundException;
import com.clinica.api.resource.model.PacienteResource;
import com.clinica.api.servicepaciente.BuscarPacientePorId;
import com.clinica.api.servicepaciente.BuscarPacienteService;
import com.clinica.api.servicepaciente.CadastroPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pac")
public class PacienteController {

    @Autowired
    private BuscarPacienteService serviceBuscar;

    @Autowired
    private CadastroPaciente serviceCadastro;

    @Autowired
    private BuscarPacientePorId serviceBuscarPorId;

    @GetMapping(path = "pacientes")
    public List<Paciente> listarPacientes() { return serviceBuscar.buscarTodosPacientes(); }
    @GetMapping(path = "paciente/id/{id}")
    public Paciente buscarPacientePorId
            (@PathVariable (name = "id", required = true) Long id) throws PacienteNotFoundException {
        return serviceBuscarPorId.buscarPorId(id);
    }

    @PostMapping(path = "paciente/save")
    public void salvarPaciente(@RequestBody PacienteResource paciente) {
        serviceCadastro.cadastro(paciente);

    }

    @DeleteMapping(path = "paciente/delete/{id}")
    public void deletarPaciente(@PathVariable (name = "id", required = true) Long id) throws PacienteNotFoundException {
        serviceBuscarPorId.deletarPorId(id);
    }
}
