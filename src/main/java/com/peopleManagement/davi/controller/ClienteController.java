package com.peopleManagement.davi.controller;

import com.peopleManagement.davi.controller.Dto.ClienteDto;
import com.peopleManagement.davi.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class ClienteController {
    ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> create(@RequestBody ClienteDto cliente) {
        try {
            return new ResponseEntity<>(this.clienteService.createCliente(cliente),
                    HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/clientes")
    public List<ClienteDto> getListCliente() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public ClienteDto getClienteById(@PathVariable Long id) {
        return clienteService.findClientById(id);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ClienteDto> updateCliente(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
        ClienteDto clienteAtualizado = clienteService.updateCliente(id, clienteDto);
        return ResponseEntity.ok(clienteAtualizado);
    }


}