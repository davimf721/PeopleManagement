package com.peopleManagement.davi.controller.Dto;
import java.io.Serializable;


public class EnderecoApiResponse implements Serializable{

    private String cep;
    private String logradouro;
    private String uf;
    private String localidade;


    public EnderecoApiResponse() {
    }

    public EnderecoApiResponse(String cep, String logradouro, String uf,  String localidade) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.uf = uf;
        this.localidade = localidade;
    }

    public String getCep(){
        return cep;
    }
    public void setCep(String cep){
        this.cep = cep;
    }
    public String getLogradouro(){

        return logradouro;

    }
    public void setLogradouro(String logradouro){
        this.logradouro = logradouro;
    }

    public String getUf(){
        return uf;

    }
    public void setUf(String uf)
    {
        this.uf = uf;
    }
    public String getLocalidade(){

        return localidade;

    }
    public void setLocalidade(String localidade){
        this.localidade = localidade;
    }
}
