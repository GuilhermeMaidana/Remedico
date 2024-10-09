package com.algaworks.crm.controller.model;



import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.RestController;

import com.algaworks.crm.model.ListaDeExames;

import com.algaworks.crm.repository.ListaDeExamesRepository;



@RequestMapping("/listadeexames")

@RestController

public class ListaDeExamesController {

	

	

	

		

		

			@Autowired

			private ListaDeExamesRepository listaDeExamesRepository;

			

			@GetMapping("/{id_listadeexames}")

			public Optional <ListaDeExames> buscar(@PathVariable Long id_listadeexames) {

				return listaDeExamesRepository.findById(id_listadeexames);

			}

			

			

			@PostMapping

		    public ListaDeExames criarExame(@RequestBody ListaDeExames listaDeExames) {

		        return listaDeExamesRepository.save(listaDeExames);

		    }

}