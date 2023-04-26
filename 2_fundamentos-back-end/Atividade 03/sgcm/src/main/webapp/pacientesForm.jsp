<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="br.ufac.sgcm.model.Paciente"%>

<!--Controller -->
<jsp:useBean 
  id="pacienteController"
  class="br.ufac.sgcm.controller.PacienteController"
  scope="page"
/>

<%


%>
<html>
    <%@ include file="include/head.jsp" %>
    <body>
        <%@ include file="include/header.jsp" %>
        <%@ include file="include/nav.jsp" %>
        <main>
           <form action="savePacienteForm.jsp" id="formCadastro" name="register-form" method="post">
      <div class="grid">

        <label for="nome">Nome</label>
        <input type="text" name="nome" class="hosp-info">

        <label for="email">E-mail</label>
        <input type="email" name="email" class="contact-info">

        <label for="telefone">Telefone</label>
        <input type="tel" name="telefone" class="contact-info">

        <label for="dataNascimento">Data de nascimento</label>
        <input type="date" name="dataNascimento" class="hosp-info">

        <label for="grupoSanguineo">Grupo sanguineo</label>
        <select name="grupoSanguineo" id="grupoSanguineo" class="grupo-sanguineo">
          <option value=""></option>
          <option value="A_POSITIVO">A POSITIVO</option>
          <option value="A_NEGATIVO">A NEGATIVO</option>
          <option value="B_POSITIVO">B POSITIVO</option>
          <option value="B_NEGATIVO">B NEGATIVO</option>
          <option value="AB_POSITIVO">AB POSITIVO</option>
          <option value="AB_NEGATIVO">AB NEGATIVO</option>
          <option value="O_POSITIVO">O POSITIVO</option>
          <option value="O_NEGATIVO">O NEGATIVO</option>
        </select>
        <label for="sexo">Sexo</label>
        <select name="sexo" id="sexo" class="hosp-info">
          <option value=""></option>
          <option value="M">M</option>
          <option value="F">F</option>
        </select>

        <label for="cep">Cep</label>
        <input type="text" name="cep" class="local-info">

        <label for="endereco">Endereco</label>
        <input type="text" name="endereco" class="local-info">

        <label for="cidade">Cidade</label>
        <input type="text" name="cidade" class="local-info">

        <label for="estado">Estado</label>
        <input type="text" name="estado" class="local-info">
      </div>
      <input type="button" value="Cancelar" id="cancel-form-button" backToPaciente="pacientes.jsp">
      <input type="submit" value="Salvar" id="save-form-button" >
    </form>
        </main>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>