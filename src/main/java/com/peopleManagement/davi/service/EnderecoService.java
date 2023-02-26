package com.peopleManagement.davi.service;

import com.peopleManagement.davi.controller.Dto.ClienteDto;
import com.peopleManagement.davi.controller.Dto.EnderecoDto;

public interface EnderecoService {

    EnderecoDto adicionarEndereco(EnderecoDto enderecoDto, ClienteDto clienteDto) throws Exception;

    EnderecoDto consultaPorCep(String cep);
}
