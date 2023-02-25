package com.peopleManagement.davi.controller.Dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class ClienteDto implements Serializable {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private List<EnderecoDto> endereco;

    public ClienteDto() {
    }

    public ClienteDto(Long id, String nome, LocalDate dataNascimento, List<EnderecoDto> endereco) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<EnderecoDto> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<EnderecoDto> endereco) {
        this.endereco = endereco;
    }
}
