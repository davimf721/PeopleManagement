package com.peopleManagement.davi.service.impl;

import com.peopleManagement.davi.controller.Dto.ClienteDto;
import com.peopleManagement.davi.controller.Dto.EnderecoDto;
import com.peopleManagement.davi.repository.ClienteRepository;
import com.peopleManagement.davi.repository.entity.ClienteEntity;
import com.peopleManagement.davi.repository.entity.EnderecoEntity;
import com.peopleManagement.davi.service.ClienteService;
import com.peopleManagement.davi.service.EnderecoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {
    static final String LINE_SEPARATOR = "line.separator";
    ClienteRepository clienteRepository;
    EnderecoService enderecoService;
    public ClienteServiceImpl(ClienteRepository clienteRepository, EnderecoService enderecoService) {
        this.clienteRepository = clienteRepository;
        this.enderecoService = enderecoService;
    }

    @Override
    public ClienteDto createCliente(ClienteDto clienteDto) throws Exception {
       if(!clienteDto.getEndereco().isEmpty()){
          fillEndereco(clienteDto.getEndereco());
       }
        final var clienteCriado = clienteRepository.save(convertToEntity(clienteDto));
        return convertToDto(clienteCriado);
    }

    private void fillEndereco(List<EnderecoDto> enderecos) {
        for (EnderecoDto endereco : enderecos) {
           var enderecoResponse = enderecoService.consultaPorCep(endereco.getCep());
           endereco.setCidade(enderecoResponse.getCidade());
           endereco.setLogradouro(enderecoResponse.getLogradouro());
        }
    }



    //Método para pegar todos os clientes
    @Override
    public List<ClienteDto> getAllClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override

    public ClienteDto findClientById(Long id) {
        final var clienteEntity = clienteRepository.findById(id);
        return clienteEntity.map(this::convertToDto).orElse(null);
    }

    public ClienteDto updateCliente(Long id, ClienteDto clienteDto) {
        ClienteEntity clienteEntity = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o id " + id));

        clienteEntity.setNome(clienteDto.getNome());
        clienteEntity.setDataNascimento(clienteDto.getDataNascimento());

        clienteRepository.save(clienteEntity);

        return convertToDto(clienteEntity);
    }

    private ClienteEntity convertToEntity(ClienteDto clienteDto) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(clienteDto.getId());
        clienteEntity.setNome(clienteDto.getNome());
        clienteEntity.setDataNascimento(clienteDto.getDataNascimento());
        var enderecoEntity = clienteDto.getEndereco()
                .stream()
                .map(this::convertEnderecoToEntity)
                .collect(Collectors.toList());
        enderecoEntity.forEach(endereco -> endereco.setCliente(clienteEntity));
        clienteEntity.setEndereco(enderecoEntity);
        return clienteEntity;
    }


    private ClienteDto convertToDto(ClienteEntity clienteEntity) {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(clienteEntity.getId());
        clienteDto.setNome(clienteEntity.getNome());
        clienteDto.setDataNascimento(clienteEntity.getDataNascimento());
        var enderecoDto = clienteEntity.getEndereco()
                .stream()
                .map(this::convertEnderecoToDto)
                .collect(Collectors.toList());
        clienteDto.setEndereco(enderecoDto);
        return clienteDto;
    }

    //Converters de endereço
    private EnderecoEntity convertEnderecoToEntity(EnderecoDto enderecoDto) {
        EnderecoEntity enderecoEntity = new EnderecoEntity();
        enderecoEntity.setId(enderecoDto.getId());
        enderecoEntity.setLogradouro(enderecoDto.getLogradouro());
        enderecoEntity.setPrincipal(enderecoDto.isPrincipal());
        enderecoEntity.setNumero(enderecoDto.getNumero());
        enderecoEntity.setCep(enderecoDto.getCep());
        enderecoEntity.setCidade(enderecoDto.getCidade());
        return enderecoEntity;
    }

    private EnderecoDto convertEnderecoToDto(EnderecoEntity enderecoEntity) {
        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setId(enderecoEntity.getId());
        enderecoDto.setLogradouro(enderecoEntity.getLogradouro());
        enderecoDto.setPrincipal(enderecoEntity.isPrincipal());
        enderecoDto.setNumero(enderecoEntity.getNumero());
        enderecoDto.setCep(enderecoEntity.getCep());
        enderecoDto.setCidade(enderecoEntity.getCidade());
        return enderecoDto;
    }

}