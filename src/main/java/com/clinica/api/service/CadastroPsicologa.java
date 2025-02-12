package com.clinica.api.service;

import com.clinica.api.datasource.model.Psicologa;
import com.clinica.api.exception.PsicologaNotFoundException;
import com.clinica.api.exception.PsicologaResourceException;
import com.clinica.api.repository.PsicologaRepository;
import com.clinica.api.resource.model.PsicologaResource;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroPsicologa {

    private static final Logger LOG = Logger
            .getLogger(CadastroPsicologa.class);

    @Autowired
    private PsicologaRepository psicologaRepository;

    @Autowired
    private PsicologaConversor service;

    public void cadastro(PsicologaResource psicologaResource) {

        try {
            Psicologa psicologa = service
                    .conversor(psicologaResource);
            psicologaRepository.saveAndFlush(psicologa);
        } catch (PsicologaResourceException e) {
            LOG.error("Erro ao salvar psicologa: " + e.getMessage(), e);
        }
    }
}
