package com.clinica.api.service.paciente;

import com.clinica.api.datasource.model.Paciente;
import com.clinica.api.exception.PacienteResourceException;
import com.clinica.api.resource.model.PacienteResource;
import org.springframework.stereotype.Component;

@Component
public class PacienteConversor {

    public Paciente conversor(PacienteResource pacienteResource)
        throws PacienteResourceException {


       try {
           if (pacienteResource == null) {
               throw new PacienteResourceException("Resource nao pode ser nulo.");
           }

           Long idPaciente = checkIdPaciente(pacienteResource.getIdPaciente());

           Paciente paciente = new Paciente();
           paciente.setIdPaciente(idPaciente);
           paciente.setNome(pacienteResource.getNome());
           paciente.setCpfPaciente(pacienteResource.getCpfPaciente());
           paciente.setTelefone(pacienteResource.getTelefone());
           paciente.setDataCadastro(pacienteResource.getDataCadastro());
           paciente.setDataNascimento(pacienteResource.getDataNascimento());

           return paciente;

       } catch (Exception e) {
           throw new PacienteResourceException("Falha ao converter resource para entidade, resource: " + pacienteResource, e);
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
    }


