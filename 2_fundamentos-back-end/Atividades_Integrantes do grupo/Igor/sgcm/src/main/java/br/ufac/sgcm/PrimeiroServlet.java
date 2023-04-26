package br.ufac.sgcm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.ufac.sgcm.dao.ProfissionalDao;
import br.ufac.sgcm.model.Profissional;
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
        for (Profissional item : profissionais) {
            saida.println(item.getNome());
            saida.println(item.getEmail());
            saida.println();
        }
    }
    
}
