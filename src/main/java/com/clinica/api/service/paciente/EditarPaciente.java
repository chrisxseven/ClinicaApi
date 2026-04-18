package com.clinica.api.service.paciente;

import com.clinica.api.datasource.model.Paciente;
import com.clinica.api.exception.PacienteResourceException;
import com.clinica.api.repository.PacienteRepository;
import com.clinica.api.resource.model.PacienteResource;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditarPaciente {

    private static final Logger LOG = Logger
            .getLogger(CadastroPaciente.class);

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteConversor service;


    public void atualizarPaciente(Long id, PacienteResource pacienteResource) {
        try {
            Paciente existente = pacienteRepository.findById(id)
                    .orElseThrow(() -> new PacienteResourceException("Paciente não encontrado: " + id));

            existente.setNome(pacienteResource.getNome());
            existente.setCpfPaciente(pacienteResource.getCpfPaciente());
            existente.setTelefone(pacienteResource.getTelefone());
            existente.setDataNascimento(pacienteResource.getDataNascimento());
            existente.setTipoTerapia(pacienteResource.getTipoTerapia());

            pacienteRepository.saveAndFlush(existente);
        } catch (PacienteResourceException e) {
            LOG.error("Erro ao atualizar paciente: " + e.getMessage(), e);
        }
    }
}
