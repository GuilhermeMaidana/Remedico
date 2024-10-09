package com.algaworks.crm.model;

import java.util.Date;
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
public class ListaDeExames {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id_listadeexames;

@Column(nullable = false)
private Date dataexame_listadeexames;

@Column(nullable = false)
private String exame_listadeexames;

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

public long getId_listadeexames() {
return id_listadeexames;
}

public void setId_listadeexames(long id_listadeexames) {
this.id_listadeexames = id_listadeexames;
}

public Date getDataexame_listadeexames() {
return dataexame_listadeexames;
}

public void setDataexame_listadeexames(Date dataexame_listadeexames) {
this.dataexame_listadeexames = dataexame_listadeexames;
}

public String getExame_listadeexames() {
return exame_listadeexames;
}

public void setExame_listadeexames(String exame_listadeexames) {
this.exame_listadeexames = exame_listadeexames;
}




@Override
    public int hashCode() {
        return Objects.hash(id_listadeexames);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ListaDeExames other = (ListaDeExames) obj;
        return id_listadeexames == other.id_listadeexames;
    }






}