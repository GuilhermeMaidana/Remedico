package com.algaworks.crm.model;


import java.util.Date;
import java.util.List;
import java.util.Objects;
import com.algaworks.crm.model.Medicamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_medicamento;

    @Column(nullable = false)
    private String nome_medicamento;

    @Column(nullable = false)
    private String descricao_medicamento;

    @Column(nullable = false)
    private Integer quantidade_medicamento;

    @Column(nullable = false)
    private Integer dosagem_medicamento;

    @Column(nullable = false)
    private Date datainicio_medicamento;

    @Column(nullable = false)
    private Date datafinal_medicamento;

    @ManyToMany
    @JoinTable(
        name = "Usuario_Medicamento",
        joinColumns = @JoinColumn(name = "id_medicamento"),
        inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private List<Usuario> usuarios;

    // Getters y Setters

    public long getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(long id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public String getNome_medicamento() {
        return nome_medicamento;
    }

    public void setNome_medicamento(String nome_medicamento) {
        this.nome_medicamento = nome_medicamento;
    }

    public String getDescricao_medicamento() {
        return descricao_medicamento;
    }

    public void setDescricao_medicamento(String descricao_medicamento) {
        this.descricao_medicamento = descricao_medicamento;
    }

    public Integer getQuantidade_medicamento() {
        return quantidade_medicamento;
    }

    public void setQuantidade_medicamento(Integer quantidade_medicamento) {
        this.quantidade_medicamento = quantidade_medicamento;
    }

    public Integer getDosagem_medicamento() {
        return dosagem_medicamento;
    }

    public void setDosagem_medicamento(Integer dosagem_medicamento) {
        this.dosagem_medicamento = dosagem_medicamento;
    }

    public Date getDatainicio_medicamento() {
        return datainicio_medicamento;
    }

    public void setDatainicio_medicamento(Date datainicio_medicamento) {
        this.datainicio_medicamento = datainicio_medicamento;
    }

    public Date getDatafinal_medicamento() {
        return datafinal_medicamento;
    }

    public void setDatafinal_medicamento(Date datafinal_medicamento) {
        this.datafinal_medicamento = datafinal_medicamento;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_medicamento);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Medicamento other = (Medicamento) obj;
        return id_medicamento == other.id_medicamento;
    }
}
