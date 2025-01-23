package com.clinica.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "psicologa")
public class Psicologa {

    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;
    private LocalDate idade;

    @Column(name = "codigo_registro")
    private String codigoRegistro;

    @Column(name = "id_paciente")
    private Long idPaciente;

    public Psicologa(String nome, LocalDate idade, String codigoRegistro, Long idPaciente) {
        this.nome = nome;
        this.idade = idade;
        this.codigoRegistro = codigoRegistro;
        this.idPaciente = idPaciente;
    }

    @SuppressWarnings("unused")
    private Psicologa() {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getIdade() {
        return idade;
    }

    public void setIdade(LocalDate idade) {
        this.idade = idade;
    }

    public String getCodigoRegistro() {
        return codigoRegistro;
    }

    public void setCodigoRegistro(String codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }
}
