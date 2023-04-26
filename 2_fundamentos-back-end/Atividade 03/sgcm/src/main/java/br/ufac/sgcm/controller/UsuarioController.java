package br.ufac.sgcm.controller;

import java.util.List;

import br.ufac.sgcm.dao.UsuarioDao;
import br.ufac.sgcm.model.Usuario;

public class UsuarioController implements IController<Usuario> {


    private UsuarioDao dao;

    public UsuarioController() {
        dao = new UsuarioDao();
    }

    @Override
    public int delete(Long id) {
        return dao.delete(id);
    }

    @Override
    public List<Usuario> get() {
        return dao.get();
    }

    @Override
    public Usuario get(Long id) {
        return dao.get(id);
    }

    @Override
    public List<Usuario> get(String termoBusca) {
        return dao.get(termoBusca);
    }

    @Override
    public int save(Usuario objeto) {
        int registrosAfetados = 0;
    if (objeto.getId() == null) {
        registrosAfetados = dao.insert(objeto);            
    } else {
        registrosAfetados = dao.update(objeto);
    }
    return registrosAfetados;
    }
}



    