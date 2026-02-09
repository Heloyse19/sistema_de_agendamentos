package com.org.sistemaAgend.service;

import com.org.sistemaAgend.model.Cliente;
import com.org.sistemaAgend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    public Cliente salvar(Cliente cliente){
        if(repository.existsByEmail(cliente.getEmail())){
            throw new RuntimeException("Já existe um cliente cadastrado com este email!");
        }
        return repository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return repository.findAll();
    }
}
