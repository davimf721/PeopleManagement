package com.peopleManagement.davi.service.impl;

import com.peopleManagement.davi.controller.Dto.ClienteDto;
import com.peopleManagement.davi.controller.Dto.EnderecoApiResponse;
import com.peopleManagement.davi.controller.Dto.EnderecoDto;
import com.peopleManagement.davi.repository.EnderecoRepository;
import com.peopleManagement.davi.repository.entity.ClienteEntity;
import com.peopleManagement.davi.repository.entity.EnderecoEntity;
import com.peopleManagement.davi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public EnderecoDto adicionarEndereco(EnderecoDto enderecoDto, ClienteDto clienteDto) {
        var clienteEntity = convertToEntity(clienteDto);
        var enderecoEntity = convertEnderecoToEntity(enderecoDto);
        validateEnderecoIsPrincipal(enderecoDto, clienteEntity);
        enderecoEntity.setCliente(clienteEntity);
        final var enderecoDados = consultaPorCep(enderecoDto.getCep());
        enderecoEntity.setCidade(enderecoDados.getCidade());
        enderecoEntity.setLogradouro(enderecoDados.getLogradouro());
        final var enderecoCadastrado = this.enderecoRepository.save(enderecoEntity);
        return convertEnderecoToDto(enderecoCadastrado);
    }

    private void validateEnderecoIsPrincipal(EnderecoDto enderecoDto, ClienteEntity clienteEntity) {
        if (enderecoDto.isPrincipal()) {
            for (EnderecoEntity entity : clienteEntity.getEndereco()) {
                entity.setPrincipal(false);
                this.enderecoRepository.save(entity);
            }
        }
    }

    @Override
    public EnderecoDto consultaPorCep(String cep) {
        final var enderecoResponse = new RestTemplate().getForEntity("https://viacep.com.br/ws/" + cep + "/json/", EnderecoApiResponse.class).getBody();
        EnderecoDto endereco = new EnderecoDto();
        assert enderecoResponse != null;
        endereco.setLogradouro(enderecoResponse.getLogradouro());
        endereco.setCidade(enderecoResponse.getLocalidade());
        endereco.setCep(enderecoResponse.getCep());
        return endereco;
    }

    private ClienteEntity convertToEntity(ClienteDto clienteDto) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(clienteDto.getId());
        clienteEntity.setNome(clienteDto.getNome());
        clienteEntity.setDataNascimento(clienteDto.getDataNascimento());
        var enderecoEntity = clienteDto.getEndereco().stream().map(this::convertEnderecoToEntity).collect(Collectors.toList());
        enderecoEntity.forEach(endereco -> endereco.setCliente(clienteEntity));
        clienteEntity.setEndereco(enderecoEntity);
        return clienteEntity;
    }

    private ClienteDto convertToDto(ClienteEntity clienteEntity) {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(clienteEntity.getId());
        clienteDto.setNome(clienteEntity.getNome());
        clienteDto.setDataNascimento(clienteEntity.getDataNascimento());
        clienteDto.setEndereco(clienteEntity.getEndereco().stream().map(this::convertEnderecoToDto).collect(Collectors.toList()));
        return clienteDto;
    }

    private EnderecoEntity convertEnderecoToEntity(EnderecoDto enderecoDto) {
        EnderecoEntity enderecoEntity = new EnderecoEntity();
        enderecoEntity.setId(enderecoDto.getId());
        enderecoEntity.setLogradouro(enderecoDto.getLogradouro());
        enderecoEntity.setNumero(enderecoDto.getNumero());
        enderecoEntity.setCep(enderecoDto.getCep());
        enderecoEntity.setPrincipal(enderecoDto.isPrincipal());
        return enderecoEntity;
    }

    private EnderecoDto convertEnderecoToDto(EnderecoEntity enderecoEntity) {
        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setId(enderecoEntity.getId());
        enderecoDto.setLogradouro(enderecoEntity.getLogradouro());
        enderecoDto.setNumero(enderecoEntity.getNumero());
        enderecoDto.setCep(enderecoEntity.getCep());
        enderecoDto.setPrincipal(enderecoEntity.isPrincipal());
        return enderecoDto;
    }

}
