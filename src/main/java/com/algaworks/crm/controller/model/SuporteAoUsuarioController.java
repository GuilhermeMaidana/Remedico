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

import com.algaworks.crm.model.SuporteAoUsuario;

import com.algaworks.crm.repository.SuporteAoUsuarioRepository;









@RequestMapping("/suporte")

@RestController

public class SuporteAoUsuarioController {

	

	//Suporte_Ao_Usuario

	

			@Autowired

			private SuporteAoUsuarioRepository suporteAoUsuarioRepository;

			

			@GetMapping("/{id_suporte}")

			public Optional<SuporteAoUsuario> buscar(@PathVariable Long id_suporte) {

				

				return suporteAoUsuarioRepository.findById(id_suporte);

			}

			

			

			@PostMapping

			@ResponseStatus(HttpStatus.CREATED)

			public SuporteAoUsuario adicionar(@RequestBody SuporteAoUsuario suporteAoUsuario) {

				return suporteAoUsuarioRepository.save(suporteAoUsuario);

			

	

	

	

}

}