package com.clinica.api.servicepsi;

import com.clinica.api.datasource.model.Psicologa;
import com.clinica.api.exception.PsicologaNotFoundException;
import com.clinica.api.repository.PsicologaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarPsicologaPorIdService {

    @Autowired
    private PsicologaRepository psicologaRepository;

    public Psicologa buscarPorId(Long id)
            throws PsicologaNotFoundException {
        Optional<Psicologa> optionalPsicologa = getOptional(id);

        Psicologa psicologa = null;
        if (!optionalPsicologa.isPresent()) {
            throw new PsicologaNotFoundException("Psicóloga não encontrada atráves do id" + id);
        } else {
            psicologa = optionalPsicologa.get();
        }
        return psicologa;
    }

    private Optional<Psicologa> getOptional(Long id) {
        Optional<Psicologa> optionalPsicologa = psicologaRepository
                .findById(id);
        return optionalPsicologa;
    }

    public void deletarPorId(Long id) throws PsicologaNotFoundException {

        Optional<Psicologa> optionalPsicologa = getOptional(id);
        if (!optionalPsicologa.isPresent()) {
            throw new PsicologaNotFoundException("Psicóloga não encontrada atráves do id" + id);
        } else {
            psicologaRepository.delete(optionalPsicologa.get());
        }
    }
}
