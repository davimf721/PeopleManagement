package com.peopleManagement.davi.controller;

import com.peopleManagement.davi.controller.Dto.ClienteDto;
import com.peopleManagement.davi.controller.Dto.EnderecoApiResponse;
import com.peopleManagement.davi.controller.Dto.EnderecoDto;
import com.peopleManagement.davi.service.ClienteService;
import com.peopleManagement.davi.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    EnderecoService enderecoService;
    ClienteService clienteService;

    public EnderecoController(EnderecoService enderecoService, ClienteService clienteService) {
        this.enderecoService = enderecoService;
        this.clienteService = clienteService;
    }

    @GetMapping("/cep/{cep}")
    public EnderecoApiResponse searchByCep(@PathVariable String cep) {
        return new RestTemplate().getForEntity("https://viacep.com.br/ws/" + cep + "/json/",
                EnderecoApiResponse.class).getBody();
    }


    @PostMapping("/cliente/{id}")
    public ResponseEntity<EnderecoDto> criarEndereco(@PathVariable(value = "id") Long clienteId,
                                                     @RequestBody EnderecoDto enderecoDto) throws Exception {
        ClienteDto cliente = clienteService.findClientById(clienteId);
        if (cliente == null) {
            return null;
        }

        EnderecoDto enderecoCriado = enderecoService.adicionarEndereco(enderecoDto, cliente);
        return ResponseEntity.ok().body(enderecoCriado);

    }

}