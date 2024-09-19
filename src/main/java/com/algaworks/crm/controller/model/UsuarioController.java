package com.algaworks.crm.controller.model;


import com.algaworks.crm.model.Medicamento;
import com.algaworks.crm.model.Usuario;
import com.algaworks.crm.repository.MedicamentoRepository;
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
	private MedicamentoRepository medicamentoRepository;
	
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
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@RequestBody Usuario usuario) {
	    List<Medicamento> medicamentos = usuario.getMedicamentos();
	    if (medicamentos != null) {
	        for (Medicamento medicamento : medicamentos) {
	        	medicamento.setUsuarios(new ArrayList<>());
	            medicamento.getUsuarios().add(usuario);
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