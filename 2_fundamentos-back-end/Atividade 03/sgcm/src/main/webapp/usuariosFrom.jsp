<%@ page pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="br.ufac.sgcm.model.Usuario" %>

<jsp:useBean
    id="controller"
    class="br.ufac.sgcm.controller.UsuarioController"
    scope="page" />

<jsp:useBean
    id="item"
    class="br.ufac.sgcm.model.Usuario"
    scope="page" />

<%
    String paramId = request.getParameter("id");
    if (paramId != null && !paramId.isEmpty()) {
        Long id = Long.parseLong(paramId);
        item = controller.get(id);
    }

    String submit = request.getParameter("submit");
    if (submit != null) {

        if (paramId != null && !paramId.isEmpty()) {
            Long id = Long.parseLong(request.getParameter("id"));
            item.setId(id);
        }

        item.setNomeCompleto(request.getParameter("nomeCompleto"));
        item.setNomeUsuario(request.getParameter("nomeUsuario"));
        item.setSenha(request.getParameter("senha"));
        item.setAtivo(Boolean.parseBoolean(request.getParameter("ativo")));
        item.setPapel(request.getParameter("papel"));        

        controller.save(item);
        pageContext.forward("usuario.jsp");
    }


%>

<!DOCTYPE html>
<html>
    <%@ include file="include/head.jsp" %>
    <body>
        <%@ include file="include/header.jsp" %>
        <%@ include file="include/nav.jsp" %>
        <main>
           <form id="formCadastro" method="post">
                <div class="grid">

                    <input type="hidden" name="id" value="<%=item.getId() != null ? item.getId() : "" %>">

                    <label for="nomeCompleto">Nome Completo</label>
                    <input type="text" name="nomeCompleto" id="nomeCompleto" value="<%=item.getNomeCompleto() != null ? item.getNomeCompleto() : "" %>" required>

                    <label for="nomeUsuario">Nome Usuario</label>
                    <input type="text" name="nomeUsuario" id="nomeUsuario" value="<%=item.getNomeUsuario() != null ? item.getNomeUsuario() : "" %>" required>

                    <label for="senha">Senha</label> 
                    <input type="text" name="senha" id="senha" value="<%=item.getSenha() != null ? item.getSenha() : "" %>" required>

                    <label for="ativo">Ativo</label>
                    <input type="checkbox" name="ativo" id="ativo" value="true" <%=item.isAtivo() ? "checked" : ""%> >

                    <label for="papel">Representante</label>
                    <input type="text" name="papel" id="papel" value="<%=item.getPapel() != null ? item.getPapel() : "" %>" required>


                </div>

                <input type="button" value="Cancelar" data-url="usuario.jsp">
                <input type="submit" name="submit" value="Salvar">

            </form>
        </main>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>