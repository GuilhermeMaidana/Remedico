package com.algaworks.crm.repository;



import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;



import com.algaworks.crm.model.ListaDeExames;

import com.algaworks.crm.model.Usuario;







@Repository

public interface ListaDeExamesRepository extends JpaRepository<ListaDeExames, Long>{

	

	@Query("SELECT usuario FROM ListaDeExames l WHERE l.id_listadeexames = :idListaDeExames")

    Usuario findUsuariosByListaDeExamesId(@Param("idListaDeExames") Long idListaDeExames);

	

	

}