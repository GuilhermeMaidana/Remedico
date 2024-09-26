package com.algaworks.crm.model;



import java.util.List; 

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

public class SuporteAoUsuario {

	

	@Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id_suporte;



    @Column(nullable = false)

    private String assunto_suporte;



    @Column(nullable = false)

    private String mensagem_suporte;

    

    

    

    

    

    @ManyToOne

    @JoinColumn(name = "id_usuario" )

    @JsonIgnore

    private Usuario usuario;

  



    //getters y setters



	public long getId_suporte() {

		return id_suporte;

	}



	

	public String getAssunto_suporte() {

		return assunto_suporte;

	}



	public void setAssunto_suporte(String assunto_suporte) {

		this.assunto_suporte = assunto_suporte;

	}



	public String getMensagem_suporte() {

		return mensagem_suporte;

	}



	public void setMensagem_suporte(String mensagem_suporte) {

		this.mensagem_suporte = mensagem_suporte;

	}

		

	

	

	

	

	public Usuario getUsuario() {

		return usuario;

	}





	public void setUsuario(Usuario usuario) {

		this.usuario = usuario;

	}





	public void setId_suporte(long id_suporte) {

		this.id_suporte = id_suporte;

	}





	@Override

    public int hashCode() {

        return Objects.hash(id_suporte);

    }



    @Override

    public boolean equals(Object obj) {

        if (this == obj)

            return true;

        if (obj == null)

            return false;

        if (getClass() != obj.getClass())

            return false;

        SuporteAoUsuario other = (SuporteAoUsuario) obj;

        return id_suporte== other.id_suporte;

    }

	

	

	

}