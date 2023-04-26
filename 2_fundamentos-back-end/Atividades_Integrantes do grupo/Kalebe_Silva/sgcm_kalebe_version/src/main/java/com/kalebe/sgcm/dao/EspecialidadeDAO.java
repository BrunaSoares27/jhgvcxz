package com.kalebe.sgcm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.kalebe.sgcm.model.Especialidade;

public class EspecialidadeDAO implements InterfaceDAO<Especialidade> {

  private PreparedStatement preparedStatement;
  private ResultSet resultSet;
  private Connection connection;
  private String sql;
  

  public EspecialidadeDAO() {
    this.connection = ConnectionDB.getConnection();
  }

  @Override
  public List<Especialidade> selectAll() {
    List<Especialidade> registers = new ArrayList<Especialidade>();

    sql = "select * from especialidade";
    try {
      preparedStatement = connection.prepareStatement(sql);
      resultSet = preparedStatement.executeQuery();
      System.out.println(resultSet);
      int count = 0;
      while (resultSet.next()) {
        Especialidade especialidade = new Especialidade();
        especialidade.setId(resultSet.getLong("id"));
        especialidade.setNome(resultSet.getString("nome"));
        System.out.println("Dentro de esp: " + especialidade.getId() + " " + especialidade.getNome());
        registers.add(especialidade);

        System.out.println(
            "LISTA DENTRO DO TRY CATCH: " + registers.get(count).getNome() + " " + registers.get(count).getId());
        count++;

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    for (Especialidade item : registers) {
      System.out.println("ANTES DE RETORNAR: " + item.getId() + " " + item.getNome());

    }
    return registers;
  }

  @Override
  public Especialidade selectByid(long id) {
    Especialidade especialidade = new Especialidade();
    sql = "SELECT * FROM especialidade where id = ?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setLong(1, id);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
       
        especialidade.setId(resultSet.getLong("id"));
        especialidade.setNome(resultSet.getString("nome"));
        
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return especialidade;

  }

  @Override
  public List selectByTerm(String term) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'selectByTerm'");
  }

  @Override
  public int insert(Especialidade object) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
  }

  @Override
  public int update(Especialidade object) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public int delete(Long object) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

}
