package com.clinica.api.controller.Paciente;

import com.clinica.api.datasource.model.Paciente;
import com.clinica.api.exception.PacienteNotFoundException;
import com.clinica.api.resource.model.PacienteResource;
import com.clinica.api.service.paciente.BuscarPacientePorId;
import com.clinica.api.service.paciente.BuscarPacienteService;
import com.clinica.api.service.paciente.CadastroPaciente;
import com.clinica.api.service.paciente.EditarPaciente;
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

    @Autowired EditarPaciente serviceEditarPaciente;

    @Autowired
    private BuscarPacientePorId serviceBuscarPorId;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "pacientes")
    public List<Paciente> listarPacientes() { return serviceBuscar.buscarTodosPacientes(); }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "paciente/id/{id}")
    public Paciente buscarPacientePorId
            (@PathVariable (name = "id", required = true) Long id) throws PacienteNotFoundException {
        return serviceBuscarPorId.buscarPorId(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "paciente/save")
    public void salvarPaciente(@RequestBody PacienteResource paciente) {
        serviceCadastro.cadastro(paciente);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "paciente/editar/{id}")
    public void atualizarPaciente(
            @PathVariable(name = "id", required = true) Long id,
            @RequestBody PacienteResource paciente) throws PacienteNotFoundException {
        serviceEditarPaciente.atualizarPaciente(id, paciente);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "paciente/delete/{id}")
    public void deletarPaciente(@PathVariable (name = "id", required = true) Long id) throws PacienteNotFoundException {
        serviceBuscarPorId.deletarPorId(id);
    }
}
