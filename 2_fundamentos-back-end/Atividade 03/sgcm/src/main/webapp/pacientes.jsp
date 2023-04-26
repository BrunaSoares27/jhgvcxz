<%@ page pageEncoding="UTF-8" %>
 
<!DOCTYPE html>
<html lang="pt-br">


<%@ page import="java.util.*"%>
<%@ page import="br.ufac.sgcm.model.Paciente"%>

<jsp:useBean
  id="controller"
  class="br.ufac.sgcm.controller.PacienteController"
  scope="page"
/>

<%


   List<Paciente> registers;

    
   registers = controller.get();

%>

<%
  String getDeleteId = request.getParameter("excluir_by_id");
  if(getDeleteId != null) controller.delete(Long.parseLong(getDeleteId));

%>

<%@ include file="./include/head.jsp"%>
<body>
  <%@ include file="./include/header.jsp"%>
  <%@ include file="./include/nav.jsp"%>
  <main>
    <a class="botao" type="button" id="add-form-button" href="pacientesForm.jsp?Adicionar">Adicionar</a>
     <div>
      <form action=""><label for="busca" placeholder="Buscas paciênte">Buscar paciênte</label>
        <input type="search" name="busca" id="busca"></form>
    </div>
    <div>
    <table>
    <thead>
      <tr>
        <th>id</th>
         <th>cep</th>
          <th>cidade</th>
           <th>data de nascimento</th>
            <th>email</th>
             <th>endereco</th>
             <th>estado </th>
             <th>grupo sanguineo</th>
             <th>nome</th>
             <th>sexo</th>
             <th>telefone</th>
             <th>Ações</th>
      </tr>
    <thead>
    <tbody>
      <% for(Paciente paciente: registers) { %>

            <tr>
                <td class="fit"> <%=paciente.getId()%> </td>
                <td> <%=paciente.getCep()%> </td>
                <td> <%=paciente.getCidade()%> </td>
                <td> <%=paciente.getDataNascimento()%> </td>
                <td> <%=paciente.getEmail()%> </td>
                <td> <%=paciente.getEndereco()%> </td>
                <td> <%=paciente.getEstado()%> </td>
                <td> <%=paciente.getGrupoSanguineo()%> </td>
                <td> <%=paciente.getNome()%> </td>
                <td> <%=paciente.getSexo()%> </td>
                <td> <%=paciente.getTelefone()%> </td>
                <td>
                            <a href="editPacientesForm.jsp?id=<%=paciente.getId() %>"
                               class="botao">Editar</a>
                            <a href="pacientes.jsp?excluir_by_id=<%=paciente.getId() %>"
                               class="botao excluir">Excluir</a>
                </td>
            
            </tr>

      <% } %>
    </tbody>
    </table>
   </div>

  </main>
  <%@ include file="./include/footer.jsp"%>
</body>

</html>
