package br.ufac.sgcm;

import java.util.List;

import br.ufac.sgcm.controller.PacienteController;
import br.ufac.sgcm.model.Paciente;

public class test {
    public static void main(String[] args) {
        Paciente p =  new Paciente();
        
        p.setCep("slaslalsa");
        p.setCidade("teste");
        p.setDataNascimento(java.sql.Date.valueOf("2022-09-03"));
        p.setEmail("tete@gmail.com");
        p.setEstado("acree");
        p.setGrupoSanguineo("o positivo");
        p.setNome("kakaroto");
        p.setSexo("m");
        p.setTelefone("6999999999");

      
        PacienteController pc =  new PacienteController();
        List<Paciente> selectAllPaciente = pc.get();
        
        for (Paciente paciente : selectAllPaciente) {
            System.out.println(paciente.getGrupoSanguineo());
        }

        System.out.println();
    }
}
