
<%@ page pageEncoding="UTF-8" %>



<%@ page import="java.sql.Date"%>

<jsp:useBean
    id="pacienteControlee"
    class="br.ufac.sgcm.controller.PacienteController"
    scope="page"

/>

<jsp:useBean
    id="paciente"
    class="br.ufac.sgcm.model.Paciente"
    scope="page"

/>
<%
    
    
    paciente.setCep(request.getParameter("cep"));
    paciente.setCidade(request.getParameter("cidade"));
    paciente.setDataNascimento(java.sql.Date.valueOf(request.getParameter("dataNascimento")));
    paciente.setEmail(request.getParameter("email"));
    paciente.setEndereco(request.getParameter("endereco"));
    paciente.setEstado(request.getParameter("estado"));
    paciente.setGrupoSanguineo(request.getParameter("grupoSanguineo"));
    paciente.setNome(request.getParameter("nome"));
    paciente.setSexo(request.getParameter("sexo"));
    paciente.setTelefone(request.getParameter("telefone"));
    pacienteControlee.save(paciente);

%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title></title>
</head>
<body>
    <script>window.location.href = "pacientes.jsp"</script>
</html>