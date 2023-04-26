<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="br.ufac.sgcm.model.Paciente"%>


<!--Controller -->
<jsp:useBean 
  id="pacienteController"
  class="br.ufac.sgcm.controller.PacienteController"
  scope="page"
/>

<jsp:useBean
  id="paciente"
  class="br.ufac.sgcm.model.Paciente"
  scope="page"
/>

<%
    String getFormId = request.getParameter("id");
    if(getFormId != null) {
      
      paciente =  pacienteController.get(Long.parseLong(getFormId));
    } 

%>
<html>
    <%@ include file="include/head.jsp" %>
    <body>
        <%@ include file="include/header.jsp" %>
        <%@ include file="include/nav.jsp" %>
        <main>
           <form action="saveEditPacienteForm.jsp" id="formCadastro" name="edit-register-form" method="post">
      <div class="grid">
        <label for="id-in-form">ID</label>
        <input type="text" name="id-in-form" value="<%=paciente.getId() == null ? "" : paciente.getId() %>" class="hosp-info" readonly>

        <label for="nome">Nome</label>
        <input type="text" name="nome" value="<%=paciente.getNome() == null ? "" : paciente.getNome() %>" class="hosp-info">

        <label for="email">E-mail</label>
        <input type="email" name="email" value="<%=paciente.getEmail() == null ? "" : paciente.getEmail()%>" class="contact-info">

        <label for="telefone">Telefone</label>
        <input type="tel" name="telefone"value="<%=paciente.getTelefone() == null ? "" : paciente.getTelefone() %>" class="contact-info">

        <label for="dataNascimento">Data de nascimento</label>
        <input type="date" name="dataNascimento" value="<%=paciente.getDataNascimento() == null ? "" : paciente.getDataNascimento() %>" class="hosp-info">

        <label for="grupoSanguineo">Grupo sanguineo</label>
        <select name="grupoSanguineo" id="grupoSanguineo" class="grupo-sanguineo">
          <option value="<%=paciente.getGrupoSanguineo().name() == null ? "" : paciente.getGrupoSanguineo().name()%>" selected><%=paciente.getGrupoSanguineo()%></option>
          
          <% ArrayList<String> bloodTypes = new ArrayList<>();
              bloodTypes.add("A_POSITIVO");
              bloodTypes.add("A_NEGATIVO");
              bloodTypes.add("B_POSITIVO");
              bloodTypes.add("B_NEGATIVO");
              bloodTypes.add("AB_POSITIVO");
              bloodTypes.add("AB_NEGATIVO");
              bloodTypes.add("O_POSITIVO");
              bloodTypes.add("O_NEGATIVO");
          %>

          <!--For para printar na tela do select tudo que não for o campo sexo do objeto -->
          <% for(int i = 0; i <= bloodTypes.size()-1; i++) {%>
          <%if(bloodTypes.get(i) != paciente.getGrupoSanguineo().name()) { %>
                  <option value="<%=bloodTypes.get(i)%>"><%=bloodTypes.get(i)%></option>
              <% } %>
          <% } %>
        </select>


        <label for="sexo">Sexo</label>
        <select name="sexo" id="sexo" class="hosp-info">
          
          <%
              List<String> sexs = new ArrayList<String>();
              sexs.add("M");
              sexs.add("F");
          %>
          
          <option value="<%=paciente.getSexo() == null ? "" : paciente.getSexo()%>"><%=paciente.getSexo()%></option>

           <!--For para printar na tela do select tudo que não for o campo sexo do objeto -->
          <%for(int i = 0; i < sexs.size(); i++) {%>
            <% if( sexs.get(i) != paciente.getSexo().name()) { %>
                    <option value="<%=paciente.getSexo()%>"><%=paciente.getSexo()%></option>

           <%}%>
          <%}%>


        </select>

        <label for="cep">Cep</label>
        <input type="text" name="cep" value="<%=paciente.getCep() == null ? "" : paciente.getCep()%>" class="local-info">

        <label for="endereco">Endereco</label>
        <input type="text" name="endereco" value="<%=paciente.getEndereco() == null ? "" : paciente.getEndereco()%>" class="local-info">

        <label for="cidade">Cidade</label>
        <input type="text" name="cidade" value="<%=paciente.getCidade() == null ? "" : paciente.getCidade()%>" class="local-info">

        <label for="estado">Estado</label>
        <input type="text" name="estado" value="<%=paciente.getEstado() == null ? "" : paciente.getEstado()%>" class="local-info">
      </div>
      <input type="button" value="Cancelar" id="cancel-form-button" backToPaciente="pacientes.jsp">
      <input type="submit" value="Salvar" id="save-form-button">
    </form>
        </main>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>

