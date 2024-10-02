package com.algaworks.crm.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Acessibilidade {

	@Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id_configacessibilidade;
	
	@Column(nullable = false)

    private Integer tamanho_fonte;
	
	
	@Column(nullable = false )
	
	private Boolean modoEscuro;
	
	@Column(nullable = false )
	private Boolean monocromatico;
	
	@Column(nullable = false )
	private Boolean negrito;
	
	
	 @ManyToOne

	    @JoinColumn(name = "id_usuario" )
	 	@JsonIgnore
        private Usuario usuario;
	
	 public Usuario getUsuario() {

			return usuario;

		}





		public void setUsuario(Usuario usuario) {

			this.usuario = usuario;

		}
	
	public long getId_configacessibilidade() {
		return id_configacessibilidade;
	}



	public void setId_configacessibilidade(long id_configacessibilidade) {
		this.id_configacessibilidade = id_configacessibilidade;
	}



	public Integer getTamanho_fonte() {
		return tamanho_fonte;
	}



	public void setTamanho_fonte(Integer tamanho_fonte) {
		this.tamanho_fonte = tamanho_fonte;
	}



	public Boolean getModoEscuro() {
		return modoEscuro;
	}



	public void setModoEscuro(Boolean modoEscuro) {
		this.modoEscuro = modoEscuro;
	}



	public Boolean getMonocromatico() {
		return monocromatico;
	}



	public void setMonocromatico(Boolean monocromatico) {
		this.monocromatico = monocromatico;
	}



	public Boolean getNegrito() {
		return negrito;
	}



	public void setNegrito(Boolean negrito) {
		this.negrito = negrito;
	}

	
	


	@Override

    public int hashCode() {

        return Objects.hash(id_configacessibilidade);

    }



    @Override

    public boolean equals(Object obj) {

        if (this == obj)

            return true;

        if (obj == null)

            return false;

        if (getClass() != obj.getClass())

            return false;

        Acessibilidade other = (Acessibilidade) obj;

        return id_configacessibilidade== other.id_configacessibilidade;

    }

}
