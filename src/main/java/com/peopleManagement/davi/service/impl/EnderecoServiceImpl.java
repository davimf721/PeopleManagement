package com.peopleManagement.davi.service.impl;

import com.peopleManagement.davi.controller.Dto.EnderecoApiResponse;
import com.peopleManagement.davi.controller.Dto.EnderecoDto;
import com.peopleManagement.davi.service.EnderecoService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {


    @Override
    public List<EnderecoDto> adicionarEndereco(Long id, EnderecoDto enderecoDto) throws Exception {
        return null;
    }

    @Override
    public EnderecoDto consultaPorCep(String cep) {
        final var enderecoResponse = new RestTemplate().getForEntity("https://viacep.com.br/ws/" + cep + "/json/",
                EnderecoApiResponse.class).getBody();
        EnderecoDto endereco = new EnderecoDto();
        endereco.setLogradouro(enderecoResponse.getLogradouro());
        endereco.setCidade(enderecoResponse.getLocalidade());
        endereco.setCep(enderecoResponse.getCep());
        return endereco;
    }
}
