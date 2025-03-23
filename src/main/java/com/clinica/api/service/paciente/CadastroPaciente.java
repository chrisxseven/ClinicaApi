package com.clinica.api.service.paciente;

import com.clinica.api.datasource.model.Paciente;
import com.clinica.api.exception.PacienteResourceException;
import com.clinica.api.repository.PacienteRepository;
import com.clinica.api.resource.model.PacienteResource;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroPaciente {

    private static final Logger LOG = Logger
            .getLogger(CadastroPaciente.class);

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteConversor service;

    public void cadastro(PacienteResource pacienteResource) {

        try{
            Paciente paciente = service
                    .conversor(pacienteResource);
            pacienteRepository.saveAndFlush(paciente);
        } catch (PacienteResourceException e) {
            LOG.error("Erro ao salvar psicolog: " + e.getMessage(), e);
        }
    }
}
