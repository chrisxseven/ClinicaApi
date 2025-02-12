package com.clinica.api.service;

import com.clinica.api.datasource.model.Psicologa;
import com.clinica.api.exception.PsicologaResourceException;
import com.clinica.api.resource.model.PsicologaResource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PsicologaConversor {

    public Psicologa conversor(PsicologaResource psicologaResource)
            throws PsicologaResourceException {

        try {
            if (psicologaResource == null) {
                throw new PsicologaResourceException("Resource não pode ser nulo.");
            }

            Long idPaciente = checkIdPaciente(psicologaResource.getIdPaciente());
            LocalDate idade = checkIdade(psicologaResource.getIdade());

            Psicologa psicologa = new Psicologa();
            psicologa.setIdPaciente(idPaciente);
            psicologa.setIdade(idade);
            psicologa.setCodigoRegistro(psicologaResource.getCodigoRegistro());
            psicologa.setNome(psicologaResource.getNome());

            return psicologa;

        } catch (Exception e) {
            throw new PsicologaResourceException("Falha ao converter resource para entidade, resource: " + psicologaResource, e);
        }
    }

    private Long checkIdPaciente(String idPaciente) {
        if (idPaciente == null || idPaciente.isBlank()) {
            throw new IllegalArgumentException("ID do paciente não pode ser nulo ou vazio.");
        }
        try {
            return Long.parseLong(idPaciente);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID do paciente inválido: " + idPaciente);
        }
    }

    private LocalDate checkIdade(String idade) {
        if (idade == null || idade.isBlank()) {
            throw new IllegalArgumentException("Idade não pode ser nula ou vazia.");
        }
        try {
            return LocalDate.parse(idade);
        } catch (Exception e) {
            throw new IllegalArgumentException("Formato de data inválido: " + idade);
        }
    }
}
