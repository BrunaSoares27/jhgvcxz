<%@ page pageEncoding="UTF-8" %>


<%@ page import="java.util.*"%>
<%@ page import="br.ufac.sgcm.model.Usuario"%>

<jsp:useBean
  id="controller"
  class="br.ufac.sgcm.controller.UsuarioController"
  scope="page"
/>

<%


   List<Usuario> registers;

    
   registers = controller.get();

%>
 
<!DOCTYPE html>
<html lang="pt-br">

<%@ include file="./include/head.jsp"%>
<body>
  <%@ include file="./include/header.jsp"%>
  <%@ include file="./include/nav.jsp"%>
  <main>
    <a class="botao" type="button" id="add-form-button">Adicionar</a>
     <div>
      <form action=""><label for="busca" placeholder="Buscas usuario">Buscar Usuarios</label>
        <input type="search" name="busca" id="busca"></form>
    </div>
    <div>
    <table>
    <thead>
      <tr>
        <th>ID</th>
         <th>Nome Completo</th>
          <th>Nome Usuario</th>
           <th>Senha</th>
            <th>Ativo</th>
             <th>Papel</th>
      </tr>
    <thead>
    <tbody>
      <% for(Usuario item: registers) { %>

            <tr>
                <td class="fit"> <%=item.getId()%> </td>
                <td> <%=item.getNomeCompleto()%> </td>
                <td> <%=item.getNomeUsuario()%> </td>
                <td> <%=item.getPapel()%> </td>
                <td><%= item.getAtivo() ? "Sim" : "Não" %></td>
                <td>
                    <a href="usuarioForm.jsp?id=<%=item.getId()%>"
                        class="botao">Editar</a>
                     <a href="usuario.jsp?excluir=<%=item.getId()%>"
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
