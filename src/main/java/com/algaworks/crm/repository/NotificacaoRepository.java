package com.algaworks.crm.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.crm.model.Notificacao;
import com.algaworks.crm.model.Usuario;



@Repository
	public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
		
		 @Query("SELECT n.usuarios FROM Notificacao n WHERE n.id_notificacao = :idNotificacao")
		    List<Usuario> findUsuariosByNotificacaoId(@Param("idNotificacao") Long idNotificacao);

	

}


