package com.algaworks.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.crm.model.Acessibilidade;
import com.algaworks.crm.model.Usuario;



@Repository

public interface AcessibilidadeRepository extends JpaRepository<Acessibilidade, Long>{

	

	

	@Query("SELECT c.usuario FROM Acessibilidade c WHERE c.id_configacessibilidade = :idConfigacessibilidade")

    List<Usuario> findUsuariosByAcessibilidadeId(@Param("idConfigacessibilidade") Long idConfigacessibilidade);


	List<Acessibilidade> getByUsuario(Usuario usuario);

	

	

	

}