package com.clinica.api.service.psi2;

import com.clinica.api.datasource.model.Psicologa;
import com.clinica.api.repository.PsicologaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarPsicologaService {

    @Autowired
    private PsicologaRepository psicologaRepository;

    public List<Psicologa> buscarTodasAsPsicologas() {
        List<Psicologa> listPsicologa = psicologaRepository.findAll();
        return listPsicologa;
    }
}

