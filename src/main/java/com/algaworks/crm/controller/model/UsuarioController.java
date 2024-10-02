package com.algaworks.crm.controller.model;


import com.algaworks.crm.model.Acessibilidade;
import com.algaworks.crm.model.Medicamento;
import com.algaworks.crm.model.Notificacao;
import com.algaworks.crm.model.SuporteAoUsuario;
import com.algaworks.crm.model.Usuario;
import com.algaworks.crm.repository.AcessibilidadeRepository;
import com.algaworks.crm.repository.MedicamentoRepository;
import com.algaworks.crm.repository.NotificacaoRepository;
import com.algaworks.crm.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/Usuario")
@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AcessibilidadeRepository acessibilidadeRepository;
	
	
	
	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Usuario buscar(@PathVariable Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	@GetMapping("/medicamento/{id_usuario}")
	public List<Medicamento> buscarmedicamentos(@PathVariable Long id_usuario) {
		return usuarioRepository.findMedicamentosByUsuarioId(id_usuario);
	}
	
	@GetMapping("/notificacao/{id_usuario}")
	public List<Notificacao> buscarnotificacao(@PathVariable Long id_usuario) {
		return usuarioRepository.findNotificacaoByUsuarioId(id_usuario);
	}
	
	
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar1(@RequestBody Usuario usuario) {
	    List<Notificacao> notificacaos = usuario.getNotificacaos();
	    List<Medicamento> medicamentos = usuario.getMedicamentos();
	   
	    if (medicamentos != null) {
	        for (Medicamento medicamento : medicamentos) {
	        	medicamento.setUsuarios(new ArrayList<>());
	            medicamento.getUsuarios().add(usuario);
	        }
	    }
	    if (notificacaos != null) {
	        for (Notificacao notificacao: notificacaos) {
	        	notificacao.setUsuarios(new ArrayList<>());
	        	notificacao.getUsuarios().add(usuario);
	        }
	    }
	    List<SuporteAoUsuario> suporteAoUsuario = usuario.getSuporteAoUsuarios();

	    if (suporteAoUsuario != null) {

	        for (SuporteAoUsuario suporteAoUsuarios : suporteAoUsuario) {

	        	suporteAoUsuarios.setUsuario(usuario);

	        }

	    }
	    List<Acessibilidade> acessibilidade = usuario.getAcessibilidades();
	    if (acessibilidade  != null) {

	        for (Acessibilidade Acessibilidades : acessibilidade) {

	        	Acessibilidades.setUsuario(usuario);

	        }

	    }
	    
	    return usuarioRepository.save(usuario);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario editar(@RequestBody Usuario usuario) {
	    List<Medicamento> medicamentos = usuario.getMedicamentos();
	    if (medicamentos != null) {
	        for (Medicamento medicamento : medicamentos) {
	        	medicamento.setUsuarios(new ArrayList<>());
	            medicamento.getUsuarios().add(usuario);
	        }
	    }
	    return usuarioRepository.save(usuario);
	}

}