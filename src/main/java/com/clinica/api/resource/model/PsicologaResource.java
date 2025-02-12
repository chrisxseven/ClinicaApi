package com.clinica.api.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PsicologaResource {

    @JsonProperty("nome_psicologa")
    private String nome;

    @JsonProperty("idade")
    private String idade;

    @JsonProperty("codigo_registro")
    private String codigoRegistro;

    @JsonProperty("id_paciente")
    private String idPaciente;

    public PsicologaResource(String nome, String idade, String codigoRegistro, String idPaciente) {
        this.nome = nome;
        this.idade = idade;
        this.codigoRegistro = codigoRegistro;
        this.idPaciente = idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCodigoRegistro() {
        return codigoRegistro;
    }

    public void setCodigoRegistro(String codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public String toString() {
        return "PsicologaResource [nome=" + nome + ", idade=" + idade + ", codigoRegistro=" + codigoRegistro + ", idPaciente=" + idPaciente + "]";
    }
}

