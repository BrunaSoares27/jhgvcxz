package br.ufac.sgcm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.ufac.sgcm.dao.EspecialidadeDao;
import br.ufac.sgcm.dao.ProfissionalDao;
import br.ufac.sgcm.dao.UnidadesDao;
import br.ufac.sgcm.model.Especialidade;
import br.ufac.sgcm.model.Profissional;
import br.ufac.sgcm.model.Unidade;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class PrimeiroServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter saida = res.getWriter();
        ProfissionalDao dao = new ProfissionalDao();
        List<Profissional> profissionais = dao.get();
        saida.println("Profissional \n");
        for (Profissional item : profissionais) {
            saida.println(item.getNome());
            saida.println(item.getEmail());
            saida.println();
        }
        ;

        EspecialidadeDao dao2 = new EspecialidadeDao();
        List<Especialidade> especialidades = dao2.get();
        saida.println("Especialidade \n");
        for (Especialidade item : especialidades) {
            saida.println(item.getNome());
            saida.println();
        }
        ;

        UnidadesDao dao3 = new UnidadesDao();
        List<Unidade> unidades = dao3.get();
        saida.println("Unidade \n");
        for (Unidade item : unidades) {
            saida.println(item.getNome());
            saida.println(item.getEndereco());
            saida.println();
        }
        ;

    }

}
