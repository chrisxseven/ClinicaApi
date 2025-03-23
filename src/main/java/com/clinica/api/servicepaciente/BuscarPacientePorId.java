package com.clinica.api.servicepaciente;

import com.clinica.api.datasource.model.Paciente;
import com.clinica.api.repository.PacienteRepository;
import com.clinica.api.exception.PacienteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarPacientePorId {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente buscarPorId(Long id)
        throws PacienteNotFoundException {
        Optional<Paciente> optionalPaciente = getOptional(id);

        Paciente paciente = null;
        if (!optionalPaciente.isPresent()) {
            throw new PacienteNotFoundException("Paciente não encontrado atráves do id" + id);
        } else {
            paciente = optionalPaciente.get();
        }
        return paciente;
    }

    private Optional<Paciente> getOptional(Long id) {
        Optional<Paciente> optionalPaciente = pacienteRepository
                .findById(id);
        return optionalPaciente;
    }

    public void deletarPorId(Long id) throws PacienteNotFoundException {
        Optional<Paciente> optionalPaciente = getOptional(id);
        if (!optionalPaciente.isPresent()) {
            throw new PacienteNotFoundException("Paciente não encontrado atráves do id" + id);
        } else {
            pacienteRepository.delete(optionalPaciente.get());
        }
    }
}
