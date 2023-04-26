package com.kalebe.sgcm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.kalebe.sgcm.dao.EspecialidadeDAO;
import com.kalebe.sgcm.dao.ProfissionalDao;
import com.kalebe.sgcm.dao.UnidadeDAO;
import com.kalebe.sgcm.model.Especialidade;
import com.kalebe.sgcm.model.Profissional;
import com.kalebe.sgcm.model.Unidade;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class PrimeiroServlet extends HttpServlet {

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    PrintWriter output = res.getWriter();
    ProfissionalDao profissionalDAO = new ProfissionalDao();
    List<Profissional> profissionais = profissionalDAO.selectAll();

    UnidadeDAO unidadeDAO = new UnidadeDAO();
    List<Unidade> unidades = unidadeDAO.selectAll();

    EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
    List<Especialidade> especialidades = especialidadeDAO.selectAll();

    output.println("Profissionais: ");
    for (Profissional element : profissionais) {
      output.print(element.getId() + " ");
      output.print(element.getEmail() + " ");
      output.print(element.getNome() + " ");
      output.print(element.getRegistroConselho() + " ");
      output.print(element.getTelefone() + " ");
      output.println();
    }
    output.println();
    output.println();

    Profissional profissionalById = profissionalDAO.selectByid(1);

    output.println("Profissionais By ID: ");
    output.print(profissionalById.getId() + " ");
    output.print(profissionalById.getEmail() + " ");
    output.print(profissionalById.getNome() + " ");
    output.print(profissionalById.getRegistroConselho() + " ");
    output.print(profissionalById.getTelefone() + " ");
    output.print(profissionalById.getEspecialidade().getNome() + " ");
    output.print(profissionalById.getUnidade().getNome() + " ");
    output.println();

    output.println();
    output.println();
    output.println("Unidades: ");
    for (Unidade element : unidades) {

      output.print(element.getId() + " ");
      output.print(element.getNome() + " ");
      output.print(element.getEndereco() + " ");
      output.println();
    }

    output.println();
    output.println();

    output.println("Especialide: ");
    for (Especialidade element : especialidades) {
      output.print(element.getNome() + " ");
      output.println();
    }
  }

}
