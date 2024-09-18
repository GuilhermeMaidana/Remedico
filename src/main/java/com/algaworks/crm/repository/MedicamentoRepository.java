package com.algaworks.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.crm.model.Medicamento;
import com.algaworks.crm.model.Usuario;



@Repository
public interface MedicamentoRepository  extends JpaRepository<Medicamento, Long> {
	
	 @Query("SELECT m.usuarios FROM Medicamento m WHERE m.id_medicamento = :idMedicamento")
	    List<Usuario> findUsuariosByMedicamentoId(@Param("idMedicamento") Long idMedicamento);
	
}
