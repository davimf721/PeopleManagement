package com.peopleManagement.davi.service;

import com.peopleManagement.davi.controller.Dto.ClienteDto;

import java.util.List;

public interface ClienteService {
    ClienteDto createCliente(ClienteDto cliente) throws Exception;

    List<ClienteDto> getAllClientes();

    ClienteDto findClientById(Long id);

    ClienteDto updateCliente(Long id, ClienteDto clienteDto);
}
