package com.clinica.api.repository;

import com.clinica.api.datasource.model.Psicologa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PsicologaRepository
        extends JpaRepository<Psicologa, Long> {
    Optional<Psicologa> findById(Long idPsicologa);
}
