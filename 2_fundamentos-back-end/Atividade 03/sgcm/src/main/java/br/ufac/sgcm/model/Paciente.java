package br.ufac.sgcm.model;

import java.io.Serializable;
import java.sql.Date;

public class Paciente implements Serializable{

  private Long id;
  private String cep;
  private String cidade;
  private Date dataNascimento;
  private String email;
  private String endereco;
  private String estado;
  private GrupoSanguineo grupoSanguineo;
  private String nome;
  private Sexo sexo;
  private String telefone;

  public Paciente(){ }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public GrupoSanguineo getGrupoSanguineo() {
    return grupoSanguineo;
  }

  public void setGrupoSanguineo(String grupoSanguineo) {

    switch(grupoSanguineo.toLowerCase()){
      case "a_positivo":
        this.grupoSanguineo = GrupoSanguineo.A_POSITIVO;
        break;
      case"a_negativo":
        this.grupoSanguineo = GrupoSanguineo.A_NEGATIVO;
        break;
      case"b_negativo":
        this.grupoSanguineo = GrupoSanguineo.B_NEGATIVO;
        break;
        case"b_positivo":
        this.grupoSanguineo = GrupoSanguineo.B_POSITIVO;
        break;
        case"ab_positivo":
        this.grupoSanguineo = GrupoSanguineo.AB_POSITIVO;
        break;
        case"ab_negativo":
        this.grupoSanguineo = GrupoSanguineo.AB_NEGATIVO;
        break;
        case"o_negativo":
        this.grupoSanguineo = GrupoSanguineo.O_NEGATIVO;
        break;
        case"o_positivo":
        this.grupoSanguineo = GrupoSanguineo.O_POSITIVO;
        break;

    }
   
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Sexo getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    switch(sexo.toLowerCase()){
      case "m":
      this.sexo = Sexo.M;
        break;
      case"f":
      this.sexo = Sexo.F;
        break;

    }
   
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  
  
}
