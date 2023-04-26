package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Unidade;

public class UnidadeDao implements IDao<Unidade> {

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    public UnidadeDao() {
        conexao = ConexaoDB.getConexao();
    }

    @Override
    public List<Unidade> get() {
        List<Unidade> registros = new ArrayList<>();
        String sql = "SELECT * FROM unidade";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Unidade registro = new Unidade();
                registro.setId(rs.getLong("id"));
                registro.setEndereco(rs.getString("endereço"));
                registro.setNome(rs.getString("nome"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public Unidade get(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<Unidade> get(String termoBusca) {
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public int insert(Unidade objeto) {
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public int update(Unidade objeto) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Unidade objeto) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}