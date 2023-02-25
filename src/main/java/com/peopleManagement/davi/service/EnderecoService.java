package com.peopleManagement.davi.service;
import com.peopleManagement.davi.controller.Dto.EnderecoDto;

import java.util.List;

public interface EnderecoService {

    List<EnderecoDto> adicionarEndereco(Long id, EnderecoDto enderecoDto) throws Exception;
    EnderecoDto consultaPorCep(String cep);
}
