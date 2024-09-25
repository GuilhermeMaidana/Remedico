package com.algaworks.crm.model;

import java.util.List;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;

    @Column(nullable = false)
    private String nome_usuario;

    @Column(nullable = false)
    private String email_usuario;

    @Column(nullable = false)
    private String senha_usuario;

    @Column(nullable = false)
    private String endereco_usuario;

    @Column(nullable = false)
    private String cpf_usuario;

    @Column(nullable = false)
    private String telefone_usuario;

    @Column(nullable = true)
    private boolean lembrarAcesso_usuario = false;


    @ManyToMany(mappedBy = "usuarios", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Medicamento> medicamentos;
    
    @ManyToMany(mappedBy = "usuarios", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Notificacao> notificacaos;

    // Getters y Setters
    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }

    public String getEndereco_usuario() {
        return endereco_usuario;
    }

    public void setEndereco_usuario(String endereco_usuario) {
        this.endereco_usuario = endereco_usuario;
    }

    public String getCpf_usuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(String cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }

    public String getTelefone_usuario() {
        return telefone_usuario;
    }

    public void setTelefone_usuario(String telefone_usuario) {
        this.telefone_usuario = telefone_usuario;
    }

    public boolean getLembrarAcesso_usuario() {
        return lembrarAcesso_usuario;
    }

    public void setLembrarAcesso_usuario(boolean lembrarAcesso_usuario) {
        this.lembrarAcesso_usuario = lembrarAcesso_usuario;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
    public List<Notificacao> getNotificacaos() {
        return notificacaos;
    }

    public void setNotificacaos(List<Notificacao> notificacaos) {
        this.notificacaos = notificacaos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_usuario);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return id_usuario == other.id_usuario;
    }
}
