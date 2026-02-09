package com.org.sistemaAgend.controller;

import com.org.sistemaAgend.model.Cliente;
import com.org.sistemaAgend.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/novo")
    public String formularioNovo(Model model){
        model.addAttribute("cliente", new Cliente());
        return "clientes/formulario"; //Página HTML
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "clientes/formulario";
        }

        try{
            service.salvar(cliente);
            attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
            return "redirect:/clientes/novo";
        } catch (RuntimeException e) {
            result.rejectValue("email", "error.cliente", e.getMessage());
            return "clientes/formulario";
        }
    }
}
