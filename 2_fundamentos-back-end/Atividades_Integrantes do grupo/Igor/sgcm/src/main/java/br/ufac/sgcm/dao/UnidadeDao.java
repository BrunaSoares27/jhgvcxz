package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Profissional;
import br.ufac.sgcm.model.Unidade;

public class UnidadeDao  implements IDao<Unidade>{

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    public UnidadeDao() {
        conexao = ConexaoDB.getConexao()
    }

    @Override
    public List<Unidade> get() {
      List<Unidade> registro = new ArrayList<>();
      String sql = "SELECT * FROM profissional";
      try{
        ps = conexao.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            Profissional registro = new Profissional();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEndereco(rs.getString("endereco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        return registros;
    


    @Override
    public Unidade get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<Unidade> get(String termoBusca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public int insert(Unidade objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public int update(Unidade objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Unidade objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
