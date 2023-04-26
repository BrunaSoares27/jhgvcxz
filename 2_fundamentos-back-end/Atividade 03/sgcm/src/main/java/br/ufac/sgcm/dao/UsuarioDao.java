package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Usuario;


public class UsuarioDao implements IDao<Usuario> {

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public UsuarioDao() {
        conexao = ConexaoDB.getConexao();
        
    }

    @Override
    public int delete(Long id) {
        int registrosAfetados = 0;
        String sql = "DELETE FROM usuario WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    @Override
    public List<Usuario> get() {
        List<Usuario> registros = new ArrayList<>();
        String sql = "SELECT * FROM usuario"; 
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuarioregistro = new Usuario();
                usuarioregistro.setId(rs.getLong("id"));
                usuarioregistro.setAtivo(rs.getBoolean("ativo"));
                usuarioregistro.setNomeCompleto(rs.getString("nome_completo"));
                usuarioregistro.setNomeUsuario(rs.getString("nome_usuario"));
                usuarioregistro.setPapel(rs.getString("papel"));
                usuarioregistro.setSenha(rs.getString("senha"));
        
                registros.add(usuarioregistro);
              }
            } catch (SQLException e) {
              e.printStackTrace();
            }
            return registros;
    }

    @Override
    public Usuario get(Long id) {
        Usuario registro = new Usuario();
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
              
                registro.setId(rs.getLong("id"));
                registro.setAtivo(rs.getBoolean("ativo"));
                registro.setNomeCompleto(rs.getString("nome_completo"));
                registro.setNomeUsuario(rs.getString("nome_usuario"));
                registro.setPapel(rs.getString("papel"));
                registro.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
          }
          return registro;
        
    }

    @Override
    public List<Usuario> get(String termoBusca) {
        List<Usuario> registros = new ArrayList<>();
        String sql = "SELECT * FROM usuario" +
            " WHERE nome_completo LIKE ?" +
            " OR nome_usuario LIKE ?" +
            " OR papel LIKE ?" +
            " OR senha LIKE ?" +
            " OR ativo LIKE ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + termoBusca + "%");
            ps.setString(2, "%" + termoBusca + "%");
            ps.setString(3, "%" + termoBusca + "%");
            ps.setString(4, "%" + termoBusca + "%");
            ps.setString(5, "%" + termoBusca + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario registro = new Usuario();
                registro.setId(rs.getLong("id"));
                registro.setAtivo(rs.getBoolean("ativo"));
                registro.setNomeCompleto(rs.getString("nome_completo"));
                registro.setNomeUsuario(rs.getString("nome_usuario"));
                registro.setPapel(rs.getString("papel"));
                registro.setSenha(rs.getString("senha"));
    
                registros.add(registro);
                registros.add(registro);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return registros;
    }

    @Override
    public int insert(Usuario objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO usuario (ativo, nome_completo, nome_usuario, papel, senha) VALUES (?, ?, ?, ?, ?)";

        try {
            ps = conexao.prepareStatement(sql);
            ps.setBoolean(1, objeto.getAtivo());
            ps.setString(2, objeto.getNomeCompleto());
            ps.setString(3, objeto.getNomeUsuario());
            ps.setString(4, objeto.getPapel());
            ps.setString(5, objeto.getSenha());             
            registrosAfetados = ps.executeUpdate();
          } catch (SQLException e) {
            e.printStackTrace();
          }
          return registrosAfetados;
    }

    @Override
    public int update(Usuario objeto) {
        int registrosAfetados = 0;
    String sql = "UPDATE usuario SET" +
        " ativo = ?," +
        " nome_completo = ?," +
        " nome_usuario = ?," +
        " papel = ?, " +
        " senha = ?," +
        " WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setBoolean(1, objeto.getAtivo());
            ps.setString(2, objeto.getNomeCompleto());
            ps.setString(3, objeto.getNomeUsuario());
            ps.setString(4, objeto.getPapel());
            ps.setString(5, objeto.getSenha());  
            ps.setLong(6, objeto.getId());
            registrosAfetados = ps.executeUpdate();
          } catch (SQLException e) {
            e.printStackTrace();
          }
          return registrosAfetados;
    }
}

    