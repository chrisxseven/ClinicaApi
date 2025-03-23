package com.clinica.api.service.psicologa;

import com.clinica.api.datasource.model.Psicologa;
import com.clinica.api.exception.PsicologaResourceException;
import com.clinica.api.resource.model.PsicologaResource;
import org.springframework.stereotype.Component;

@Component
public class PsicologaConversor {

    public Psicologa conversor(PsicologaResource psicologaResource)
            throws PsicologaResourceException {

        try {
            if (psicologaResource == null) {
                throw new PsicologaResourceException("Resource não pode ser nulo.");
            }

            Long idPsicologa = checkIdPsicologa(psicologaResource.getIdPsicologa());

            Psicologa psicologa = new Psicologa();
            psicologa.setIdPsicologa(idPsicologa);
            psicologa.setCrPsi(psicologaResource.getCrPsi());
            psicologa.setNome(psicologaResource.getNome());

            return psicologa;

        } catch (Exception e) {
            throw new PsicologaResourceException("Falha ao converter resource para entidade, resource: " + psicologaResource, e);
        }
    }

    private Long checkIdPsicologa(String idPsicologa) {
        if (idPsicologa == null || idPsicologa.isBlank()) {
            throw new IllegalArgumentException("ID da Psicologa não pode ser nulo ou vazio.");
        }
        try {
            return Long.parseLong(idPsicologa);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID da Psicologa inválido: " + idPsicologa);
        }
    }
}
