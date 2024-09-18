package com.algaworks.crm.controller.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.crm.model.Medicamento;
import com.algaworks.crm.repository.MedicamentoRepository;


@RequestMapping("/medicamento")
@RestController
public class MedicamentoController {
	//MEDICAMENTO
	
		@Autowired
		private MedicamentoRepository medicamentoRepository;
		
		@GetMapping("/{id_medicamento}")
		public Medicamento buscar(@PathVariable Long id_medicamento) {
			return medicamentoRepository.findById(id_medicamento).get();
		}
		
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Medicamento adicionar(@RequestBody Medicamento medicamento) {
			return medicamentoRepository.save(medicamento);
		}
		
}
