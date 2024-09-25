package com.algaworks.crm.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_notificacao;
    
    @Column(nullable = false)
    private String notificacaoLembrete;
    
 

	@Column(nullable = false)
    private String notificacaoAntiga;
    
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "USUARIO_NOTIFICACAO",
        joinColumns = @JoinColumn(name = "id_notificacao"),
        inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    @JsonIgnore
    private List<Usuario> usuarios;
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
   

	public long getId_notificacao() {
		return id_notificacao;
	}

	public void setId_notificacao(long id_notificacao) {
		this.id_notificacao = id_notificacao;
	}

	public String getNotificacaoLembrete() {
		return notificacaoLembrete;
	}

	public void setNotificacaoLembrete(String notificacaoLembrete) {
		this.notificacaoLembrete = notificacaoLembrete;
	}

	public String getNotificacaoAntiga() {
		return notificacaoAntiga;
	}

	public void setNotificacaoAntiga(String notificacaoAntiga) {
		this.notificacaoAntiga = notificacaoAntiga;
	}
	@Override
    public int hashCode() {
        return Objects.hash(id_notificacao);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Notificacao other = (Notificacao) obj;
        return id_notificacao == other.id_notificacao;
    }
}
