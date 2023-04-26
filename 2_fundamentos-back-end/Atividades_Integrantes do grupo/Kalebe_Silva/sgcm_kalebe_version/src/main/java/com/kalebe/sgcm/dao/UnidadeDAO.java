package com.kalebe.sgcm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kalebe.sgcm.model.Unidade;

public class UnidadeDAO implements InterfaceDAO {
  private Connection conection;
  private PreparedStatement preparedStatement;
  private ResultSet resultSet;



  private String sql;

  public UnidadeDAO() {
    this.conection = ConnectionDB.getConnection();
  }

  @Override
  public List<Unidade> selectAll() {
    List<Unidade> registers = new ArrayList<Unidade>();
    sql = "SELECT * from unidade";
    try {
      preparedStatement = conection.prepareStatement(sql);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        Unidade unidade = new Unidade();
        unidade.setId(resultSet.getLong("id"));
        unidade.setNome(resultSet.getString("nome"));
        unidade.setEndereco(resultSet.getString("endereco"));
        registers.add(unidade);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return registers;

  }

  @Override
  public Unidade selectByid(long id) {
    sql = "SELECT * FROM unidade where id = ?";
    Unidade unidade = new Unidade();
    try {
      preparedStatement = conection.prepareStatement(sql);
      preparedStatement.setLong(1, id);
      resultSet = preparedStatement.executeQuery();
      if(resultSet.next()){
        unidade.setId(resultSet.getLong("id"));
        unidade.setNome(resultSet.getString("nome"));
      }
    } catch (Exception e) {
      // TODO: handle exception
    }

    return unidade;
  }

  @Override
  public List selectByTerm(String term) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'selectByTerm'");
  }

  @Override
  public int insert(Object object) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
  }

  @Override
  public int update(Object object) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public int delete(Long object) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

}
