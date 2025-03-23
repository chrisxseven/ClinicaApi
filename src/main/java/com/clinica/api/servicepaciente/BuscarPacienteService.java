package com.clinica.api.servicepaciente;

import com.clinica.api.datasource.model.Paciente;
import com.clinica.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarPacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> buscarTodosPacientes () {
        List<Paciente> listPaciente = pacienteRepository.findAll();
        return listPaciente;
    }
}
