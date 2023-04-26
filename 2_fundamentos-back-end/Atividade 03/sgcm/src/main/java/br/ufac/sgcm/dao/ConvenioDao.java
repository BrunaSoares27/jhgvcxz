package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Convenio;

public class ConvenioDao implements IDao<Convenio> {

  private Connection conexao;
  private PreparedStatement ps;
  private ResultSet rs;


  public ConvenioDao() {
    conexao = ConexaoDB.getConexao();
  }

  @Override
  public List<Convenio> get() {
    List<Convenio> registros = new ArrayList<>();
    String sql = "SELECT * FROM convenio";

    try {
      ps = conexao.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        Convenio registro = new Convenio();
        registro.setId(rs.getLong("id"));
        registro.setNome(rs.getString("nome"));
        registro.setRazaoSocial(rs.getString("razao_social"));
        registro.setCnpj(rs.getString("cnpj"));
        registro.setRepresentante(rs.getString("representante"));
        registro.setEmail(rs.getString("email"));
        registro.setTelefone(rs.getString("telefone"));
        registro.setAtivo(rs.getBoolean("ativo"));

        registros.add(registro);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return registros;
  }

  @Override
  public Convenio get(Long id) {
    Convenio registro = new Convenio();
    String sql = "SELECT * FROM convenio WHERE id = ?";

    try {
      ps = conexao.prepareStatement(sql);
      ps.setLong(1, id);
      rs = ps.executeQuery();
      if (rs.next()) {
        registro.setId(rs.getLong("id"));
        registro.setNome(rs.getString("nome"));
        registro.setRazaoSocial(rs.getString("razao_social"));
        registro.setCnpj(rs.getString("cnpj"));
        registro.setRepresentante(rs.getString("representante"));
        registro.setEmail(rs.getString("email"));
        registro.setTelefone(rs.getString("telefone"));
        registro.setAtivo(rs.getBoolean("ativo"));
    }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return registro;
  }

  @Override
  public List<Convenio> get(String termoBusca) {
    List<Convenio> registros = new ArrayList<>();
    String sql = "SELECT * FROM convenio" +
        " WHERE nome LIKE ?" +
        " OR razao_social LIKE ?" +
        " OR cnpj LIKE ?" +
        " OR representante LIKE ?" +
        " OR email LIKE ?" +
        " OR telefone LIKE ?" +
        " OR ativo LIKE ?";
    try {
        ps = conexao.prepareStatement(sql);
        ps.setString(1, "%" + termoBusca + "%");
        ps.setString(2, "%" + termoBusca + "%");
        ps.setString(3, "%" + termoBusca + "%");
        ps.setString(4, "%" + termoBusca + "%");
        ps.setString(5, "%" + termoBusca + "%");
        ps.setString(6, "%" + termoBusca + "%");
        ps.setString(7, "%" + termoBusca + "%");
        rs = ps.executeQuery();
        while (rs.next()) {
            Convenio registro = new Convenio();
            registro.setId(rs.getLong("id"));
            registro.setNome(rs.getString("nome"));
            registro.setRazaoSocial(rs.getString("razao_social"));
            registro.setCnpj(rs.getString("cnpj"));
            registro.setRepresentante(rs.getString("representante"));
            registro.setEmail(rs.getString("email"));
            registro.setTelefone(rs.getString("telefone"));
            registro.setAtivo(rs.getBoolean("ativo"));

            registros.add(registro);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return registros;
  }

  @Override
  public int insert(Convenio objeto) {
    int registrosAfetados = 0;
    String sql = "INSERT INTO convenio (nome, razao_social, cnpj, representante, email, telefone, ativo) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try {
      ps = conexao.prepareStatement(sql);
      ps.setString(1, objeto.getNome());
      ps.setString(2, objeto.getRazaoSocial());
      ps.setString(3, objeto.getCnpj());
      ps.setString(4, objeto.getRepresentante());
      ps.setString(5, objeto.getEmail());
      ps.setString(6, objeto.getTelefone());
      ps.setBoolean(7, objeto.isAtivo());
      registrosAfetados = ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return registrosAfetados;
  }

  @Override
  public int update(Convenio objeto) {
    int registrosAfetados = 0;
    String sql = "UPDATE convenio SET" +
        " nome = ?," +
        " razao_social = ?," +
        " cnpj = ?," +
        " representante = ?, " +
        " email = ?," +
        " telefone = ?," +
        " ativo = ?" +
        " WHERE id = ?";

      try {
        ps = conexao.prepareStatement(sql);
        ps.setString(1, objeto.getNome());
        ps.setString(2, objeto.getRazaoSocial());
        ps.setString(3, objeto.getCnpj());
        ps.setString(4, objeto.getRepresentante());
        ps.setString(5, objeto.getEmail());
        ps.setString(6, objeto.getTelefone());
        ps.setBoolean(7, objeto.isAtivo());
        ps.setLong(8, objeto.getId());
        registrosAfetados = ps.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return registrosAfetados;
  }

  @Override
  public int delete(Long id) {
    int registrosAfetados = 0;
    String sql = "DELETE FROM convenio WHERE id = ?";
    try {
        ps = conexao.prepareStatement(sql);
        ps.setLong(1, id);
        registrosAfetados = ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return registrosAfetados;
  }
}
