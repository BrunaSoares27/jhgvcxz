package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Paciente;

public class PacienteDao implements IDao<Paciente> {

  private Connection connection;
  private PreparedStatement preparableStatement;
  private ResultSet resultSet;

  public PacienteDao() {

    this.connection = ConexaoDB.getConexao();

  }

  @Override
  public List<Paciente> get() {
    List<Paciente> registers = new ArrayList<Paciente>();
    String sql = "SELECT * from paciente";
    try {
      preparableStatement =  connection.prepareStatement(sql);
      resultSet =  preparableStatement.executeQuery();
      while(resultSet.next()) {
      
        Paciente paciente = new Paciente();
        paciente.setId(resultSet.getLong("id"));
        paciente.setCep(resultSet.getString("cep"));
        paciente.setCidade(resultSet.getString("cidade"));
        paciente.setDataNascimento(resultSet.getDate("data_nascimento"));
        paciente.setEmail(resultSet.getString("email"));
        paciente.setEndereco(resultSet.getString("endereco"));
        paciente.setEstado(resultSet.getString("estado"));
        paciente.setGrupoSanguineo(resultSet.getString("grupo_sanguineo"));
        System.out.println(paciente.getGrupoSanguineo());
        paciente.setNome(resultSet.getString("nome"));
        paciente.setSexo(resultSet.getString("sexo"));
        paciente.setTelefone(resultSet.getString("telefone"));
        registers.add(paciente);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return registers;
  }

  @Override
  public Paciente get(Long id) {
    Paciente paciente = new Paciente();
    String sql = "select * from paciente where id=?";
    try {
      preparableStatement = connection.prepareStatement(sql);
      preparableStatement.setLong(1, id);
      resultSet = preparableStatement.executeQuery();
      if(resultSet.next()){
       
        paciente.setId(resultSet.getLong("id"));
        paciente.setCep(resultSet.getString("cep"));
        paciente.setCidade(resultSet.getString("cidade"));
        paciente.setDataNascimento(resultSet.getDate("data_nascimento"));
        paciente.setEmail(resultSet.getString("email"));
        paciente.setEndereco(resultSet.getString("endereco"));
        paciente.setEstado(resultSet.getString("estado"));
        paciente.setGrupoSanguineo(resultSet.getString("grupo_sanguineo"));
        paciente.setNome(resultSet.getString("nome"));
        paciente.setSexo(resultSet.getString("sexo"));
        paciente.setTelefone(resultSet.getString("telefone"));
      }
    } catch (SQLException e) {
     
      e.printStackTrace();
    }
    return paciente;

  }

  @Override
  public List<Paciente> get(String termoBusca) {
    String sql =  "select * from paciente where id like %?% or cep like %?% or cidade like %?% " +
                  "or data_nascimento like %?% or email like %?% or estado like %?% or grupo_sanguineo" +
                  " like %?% or nome like %?% or sexo like %?% or telefone like %?%";
    List<Paciente> registersPacient = new ArrayList<Paciente>();
    try {
      preparableStatement = connection.prepareStatement(sql);
      preparableStatement.setString(1, termoBusca);
      preparableStatement.setString(2, termoBusca);
      preparableStatement.setString(3, termoBusca);
      preparableStatement.setString(4, termoBusca);
      preparableStatement.setString(5, termoBusca);
      preparableStatement.setString(6, termoBusca);
      preparableStatement.setString(7, termoBusca);
      preparableStatement.setString(8, termoBusca);
      preparableStatement.setString(9, termoBusca);
      preparableStatement.setString(10, termoBusca);
      resultSet = preparableStatement.executeQuery();
      while(resultSet.next()) {
        Paciente paciente = new Paciente();
        paciente.setId(resultSet.getLong("id"));
        paciente.setCep(resultSet.getString("cep"));
        paciente.setCidade(resultSet.getString("cidade"));
        paciente.setDataNascimento(resultSet.getDate("data_nascimento"));
        paciente.setEmail(resultSet.getString("email"));
        paciente.setEndereco(resultSet.getString("endereco"));
        paciente.setEstado(resultSet.getString("estado"));
        paciente.setGrupoSanguineo(resultSet.getString("grupo_sanguineo"));
        paciente.setNome(resultSet.getString("nome"));
        paciente.setSexo(resultSet.getString("sexo"));
        paciente.setTelefone(resultSet.getString("telefone"));
        registersPacient.add(paciente);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return registersPacient;
  }

  @Override
  public int insert(Paciente objeto) {
    int numberOfInsertRegisters = 0;
    String sql = "insert into paciente (`cep`,`cidade`,`data_nascimento`,`email`," +
                  "`endereco`,`estado`,`grupo_sanguineo`,`nome`,`sexo`,`telefone`) " 
                  + "values (?,?,?,?,?,?,?,?,?,?)";
    try {
      preparableStatement =  connection.prepareStatement(sql);
      preparableStatement.setString(1, objeto.getCep());
      preparableStatement.setString(2, objeto.getCidade());
      preparableStatement.setString(3, objeto.getDataNascimento().toString());
      preparableStatement.setString(4, objeto.getEmail());
      preparableStatement.setString(5, objeto.getEndereco());
      preparableStatement.setString(6, objeto.getEstado());
      preparableStatement.setString(7, objeto.getSexo().name());
      preparableStatement.setString(8, objeto.getNome());
      preparableStatement.setString(9, objeto.getSexo().name());
      preparableStatement.setString(10, objeto.getTelefone());
      numberOfInsertRegisters = preparableStatement.executeUpdate();
    } catch (SQLException e) {
      
      e.printStackTrace();
    }

    return numberOfInsertRegisters;
  }

  @Override
  public int update(Paciente objeto) {
    int numberOfUpdates = 0 ;
    String sql = "Update paciente SET `cep` = ?, `cidade` = ?, `data_nascimento` = ?," +
                 "`email` = ?, `endereco` = ? , `estado` = ?, `grupo_sanguineo` = ?, `nome` = ?,`sexo`  = ?, `telefone`= ? " +
                 "WHERE id = ?";

                 
    try {
      preparableStatement =  connection.prepareStatement(sql);
      preparableStatement.setString(1, objeto.getCep());
      preparableStatement.setString(2, objeto.getCidade());
      preparableStatement.setString(3, objeto.getDataNascimento().toString());
      preparableStatement.setString(4, objeto.getEmail());
      preparableStatement.setString(5, objeto.getEndereco());
      preparableStatement.setString(6, objeto.getEstado());
      preparableStatement.setString(7, objeto.getGrupoSanguineo().name());
      preparableStatement.setString(8, objeto.getNome());
      preparableStatement.setString(9, objeto.getSexo().name());
      preparableStatement.setString(10, objeto.getTelefone());
      numberOfUpdates = preparableStatement.executeUpdate();

    } catch (SQLException e) {
    
      e.printStackTrace();
    }
    return numberOfUpdates;
  }

  @Override
  public int delete(Long id) {
    int numberOfDeleteData = 0;
    String sql = "Delete From paciente where id=?";
    try {
      preparableStatement = connection.prepareStatement(sql);
      preparableStatement.setString(1, Long.toString(id));
      numberOfDeleteData = preparableStatement.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return numberOfDeleteData;
  }

  

  

}
