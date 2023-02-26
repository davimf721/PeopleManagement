package com.peopleManagement.davi.controller;

import com.peopleManagement.davi.controller.Dto.ClienteDto;
import com.peopleManagement.davi.controller.Dto.EnderecoDto;
import com.peopleManagement.davi.service.ClienteService;
import com.peopleManagement.davi.service.EnderecoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class EnderecoControllerTest {
    @Mock
    EnderecoService enderecoService;
    @Mock
    ClienteService clienteService;

    @Test
    public void testCriarEndereco() throws Exception {
        EnderecoController enderecoController = new EnderecoController(enderecoService, clienteService);
        when(clienteService.findClientById(any())).thenReturn(new ClienteDto(1L, "nome", LocalDate.now()
                , List.of(new EnderecoDto())));
        when(enderecoService.adicionarEndereco(any(EnderecoDto.class), any())).thenReturn(new EnderecoDto(1L, "Rua Teste", true,
                "42", "12345678", "Cidade Teste"));
        EnderecoDto enderecoDto = buildRequest();
        final var response = enderecoController.criarEndereco(1L, enderecoDto);
        assertNotNull(response);
        assertEquals("12345678", response.getBody().getCep());
        assertEquals("Rua Teste", response.getBody().getLogradouro());
        assertEquals("42", response.getBody().getNumero());
        assertEquals("Cidade Teste", response.getBody().getCidade());
    }

    private static EnderecoDto buildRequest() {
        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setCep("12345678");
        enderecoDto.setLogradouro("Rua Teste");
        enderecoDto.setCidade("Cidade Teste");
        return enderecoDto;
    }

}