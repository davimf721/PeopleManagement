package com.peopleManagement.davi.controller.Dto;

import java.io.Serializable;

public class EnderecoDto implements Serializable {
    private Long id;
    private String logradouro;
    private boolean principal;
    private String numero;
    private String cep;
    private String cidade;

    public EnderecoDto(Long id, String logradouro, boolean principal, String numero, String cep, String cidade) {
        this.id = id;
        this.logradouro = logradouro;
        this.principal = principal;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
    }

    public EnderecoDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
