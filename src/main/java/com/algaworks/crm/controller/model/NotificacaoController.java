package com.algaworks.crm.controller.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.algaworks.crm.model.Notificacao;
import com.algaworks.crm.repository.NotificacaoRepository;

@RequestMapping("/notificacao")
@RestController
public class NotificacaoController {
	//NOTIFICACAO
	@Autowired
	private NotificacaoRepository notificacaoRepository;
	
	@GetMapping("/{id_notificacao}")
	public Notificacao  buscar(@PathVariable Long id_notificacao) {
		return notificacaoRepository.findById(id_notificacao).get();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Notificacao adicionar(@RequestBody Notificacao notificacao) {
		return notificacaoRepository.save(notificacao);
	}
}
