package com.peopleManagement.davi.repository.entity;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "endereco")
public class EnderecoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cep")
    private String cep;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "principal")
    private boolean principal;
    @Column(name = "numero")
    private String numero;
    @Column(name = "cidade")
    private String cidade;
    @JoinColumn(name = "cliente_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteEntity cliente;

    public EnderecoEntity() {
    }


    public EnderecoEntity(Long id, String logradouro, boolean principal, String numero, String cep,
                          String cidade, ClienteEntity cliente) {
        this.id = id;
        this.logradouro = logradouro;
        this.principal = principal;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.cliente = cliente;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
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
