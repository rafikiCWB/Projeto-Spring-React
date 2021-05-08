package com.devsuperior.dsvendas.service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    public List<SellerDTO> findAll() {
        List<Seller> result = repository.findAll();
        return result.stream().map(SellerDTO::new).collect(Collectors.toList());

    }
}
//@Service -Registra uma classe sendo como um componente do sistema, dessa forma esse componente
// vai poder sem injetado em outros componentes;

//por padrao o JPA ja é um componente

// a camada de serviço conversa com a camada de acesso a dados
// @Autowired vai injetar uma dependencia de forma transparente

//implementação simples de serviço de venda que por sua vez depende de um reposito de venda
//ai ele vai ter um metodo buscar todos e por sua vez chama o buscar todos em seu repositorio
