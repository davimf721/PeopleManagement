package com.peopleManagement.davi.controller;

import com.peopleManagement.davi.controller.Dto.EnderecoApiResponse;
import com.peopleManagement.davi.controller.Dto.EnderecoDto;
import com.peopleManagement.davi.service.EnderecoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/cep/{cep}")
    public EnderecoApiResponse searchByCep(@PathVariable String cep) {
        return new RestTemplate().getForEntity("https://viacep.com.br/ws/" + cep + "/json/",
                EnderecoApiResponse.class).getBody();
    }
    @PostMapping("/cliente/{id}")
    public List<EnderecoDto> createEndereco(@PathVariable Long id, @RequestBody EnderecoDto endereco) throws Exception {
        return enderecoService.adicionarEndereco(id,endereco);
    }
}