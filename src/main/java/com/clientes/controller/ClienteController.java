package com.clientes.controller;

import com.clientes.model.ClienteModel;
import com.clientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteModel> Listatodos(){
        return clienteRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<ClienteModel> BuscarID(@PathVariable Long id){
        return  clienteRepository.findById(id);

    }

    @PostMapping
    public ClienteModel salvar(@RequestBody ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);

    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clienteRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }
}
