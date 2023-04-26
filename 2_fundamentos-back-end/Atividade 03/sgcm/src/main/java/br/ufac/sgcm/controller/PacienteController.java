package br.ufac.sgcm.controller;

import java.util.List;

import br.ufac.sgcm.dao.PacienteDao;
import br.ufac.sgcm.model.Paciente;

public class PacienteController implements IController<Paciente> {

  PacienteDao pacientedao =  new PacienteDao();

  @Override
  public List<Paciente> get() {

    return pacientedao.get();
    
  }

  @Override
  public Paciente get(Long id) {
    return pacientedao.get(id);
  }

  @Override
  public List<Paciente> get(String termoBusca) {
    return pacientedao.get(termoBusca);
  }

  @Override
  public int save(Paciente objeto) {
    int alterRegisterNumber = 0;
    if(objeto.getId() == null){
      alterRegisterNumber = pacientedao.insert(objeto);
    }
    return alterRegisterNumber;
    
  }

  public int update(Paciente objeto) {
    int alteredRegistersNumber = 0;

    alteredRegistersNumber = pacientedao.update(objeto);

    return alteredRegistersNumber;
  }

  @Override
  public int delete(Long id) {
    int alterRegisterNumber = 0;
    alterRegisterNumber = pacientedao.delete(id);
    return alterRegisterNumber;
  }
  
}
