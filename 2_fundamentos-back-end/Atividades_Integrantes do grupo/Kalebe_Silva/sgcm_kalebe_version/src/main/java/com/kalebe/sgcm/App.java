package com.kalebe.sgcm;

import java.util.List;

import com.kalebe.sgcm.dao.EspecialidadeDAO;
import com.kalebe.sgcm.model.Especialidade;

public class App {
    public static void main(String[] args) {
        EspecialidadeDAO espDAO = new EspecialidadeDAO();
        List<Especialidade> especialidade = espDAO.selectAll();

        for(int i = 0; i < especialidade.size()-1; i++) {
            System.out.println("No main: " + especialidade.get(i).getId() + " "+ especialidade.get(i).getNome());
        }

    }
}
