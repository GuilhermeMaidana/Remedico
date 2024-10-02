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

import com.algaworks.crm.model.Acessibilidade;
import com.algaworks.crm.repository.AcessibilidadeRepository;


@RequestMapping("/acessibilidade")

@RestController

public class AcessibilidadeController {
	
	



		

		//Suporte_Ao_Usuario

		

				@Autowired

				private AcessibilidadeRepository AcessibilidadeRepository;

				

				@GetMapping("/{id_configacessibilidade}")

				public Optional<Acessibilidade> buscar(@PathVariable Long id_configacessibilidade) {

					

					return AcessibilidadeRepository.findById(id_configacessibilidade);

				}

				

				

				@PostMapping

				@ResponseStatus(HttpStatus.CREATED)

				public Acessibilidade adicionar(@RequestBody Acessibilidade cONFIGURACOES_DE_ACESSIBILIDADE) {

					return AcessibilidadeRepository.save(cONFIGURACOES_DE_ACESSIBILIDADE);
}
				}
