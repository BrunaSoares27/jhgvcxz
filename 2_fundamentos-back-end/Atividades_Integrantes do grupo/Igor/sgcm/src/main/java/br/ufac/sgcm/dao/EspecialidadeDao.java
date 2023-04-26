package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Especialidade;
import br.ufac.sgcm.model.Profissional;

public class EspecialidadeDao  implements IDao<Especialidade>{

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    
    public EspecialidadeDao() {
        conexao = ConexaoDB.getConexao();
    }

    
    @Override
    public List<Especialidade> get() {
        List<Especialidade> registros = new ArrayList<>();
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
    public Especialidade get(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<Especialidade> get(String termoBusca) 
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public int insert(Especialidade objeto) {
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public int update(Especialidade objeto) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Especialidade objeto) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }








}
    

