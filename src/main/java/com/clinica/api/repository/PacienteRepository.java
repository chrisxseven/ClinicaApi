package com.clinica.api.repository;

import com.clinica.api.datasource.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository
        extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findById(Long idPaciente);
}
