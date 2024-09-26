package com.algaworks.crm.repository;



import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;



import com.algaworks.crm.model.SuporteAoUsuario;

import com.algaworks.crm.model.Usuario;







@Repository

public interface SuporteAoUsuarioRepository extends JpaRepository<SuporteAoUsuario, Long>{

	

	

	@Query("SELECT s.usuario FROM SuporteAoUsuario s WHERE s.id_suporte = :idSuporte")

    List<Usuario> findUsuariosBySuporteAoUsuarioId(@Param("idSuporte") Long idSuporte);

	

	

	

}