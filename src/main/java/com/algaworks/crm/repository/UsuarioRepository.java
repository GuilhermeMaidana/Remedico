package com.algaworks.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.crm.model.Medicamento;
import com.algaworks.crm.model.Notificacao;
import com.algaworks.crm.model.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	
	@Query("SELECT u.medicamentos FROM Usuario u WHERE u.id_usuario = :idUsuario")
    List<Medicamento> findMedicamentosByUsuarioId(@Param("idUsuario") Long idUsuario);
	
	@Query("SELECT u.notificacaos FROM Usuario u WHERE u.id_usuario = :idUsuario")
    List<Notificacao> findNotificacaoByUsuarioId(@Param("idUsuario") Long idUsuario);
	
	
}
