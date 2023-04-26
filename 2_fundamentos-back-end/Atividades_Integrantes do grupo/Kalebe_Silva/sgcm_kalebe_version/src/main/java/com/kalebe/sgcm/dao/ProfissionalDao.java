package com.kalebe.sgcm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.kalebe.sgcm.model.Profissional;

public class ProfissionalDao implements InterfaceDAO {

  private Connection connection;
  private PreparedStatement preparedStatement;
  private ResultSet resultSet;
  private Profissional profissionalRegister = new Profissional();
  private String sql;
  private EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
  private UnidadeDAO unidadeDAO = new UnidadeDAO();
  

  public ProfissionalDao() {
    this.connection = ConnectionDB.getConnection();

  }

  @Override
  public List<Profissional> selectAll() {
    List<Profissional> registers = new ArrayList<Profissional>();
    sql = "SELECT * FROM profissional";
    try {
      preparedStatement = connection.prepareStatement(sql);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        profissionalRegister.setId(resultSet.getLong("id"));
        profissionalRegister.setEmail(resultSet.getString("email"));
        profissionalRegister.setNome(resultSet.getString("nome"));
        profissionalRegister.setRegistroConselho(resultSet.getString("registro_conselho"));
        profissionalRegister.setTelefone(resultSet.getString("telefone"));
        registers.add(profissionalRegister);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return registers;
  }

  @Override
  public Profissional selectByid(long id) {
    sql = "SELECT * from profissional where id = ?";
    Profissional prof = new Profissional();
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setLong(1, id);
      resultSet = preparedStatement.executeQuery();
      if(resultSet.next()){
        prof.setId(resultSet.getLong("id"));
        prof.setEmail(resultSet.getString("email"));
        prof.setNome(resultSet.getString("nome"));
        prof.setRegistroConselho(resultSet.getString("registro_conselho"));
        prof.setTelefone(resultSet.getString("telefone"));
        prof.setEspecialidade(especialidadeDAO.selectByid(id));
        prof.setUnidade(unidadeDAO.selectByid(id));
      }

    } catch (Exception e) {
      // TODO: handle exception
    }

    return prof;
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
