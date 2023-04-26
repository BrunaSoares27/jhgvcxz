<%@ page pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="br.ufac.sgcm.model.Profissional" %>

<jsp:useBean
    id="controller"
    class="br.ufac.sgcm.controller.ProfissionalController"
    scope="page" />

<%

    String paramExcluir = request.getParameter("excluir");
    if (paramExcluir != null) {
        Long id = Long.parseLong(paramExcluir);
        controller.delete(id);
    }

    List<Profissional> registros = controller.get();

%>

<!DOCTYPE html>
<html>
   <%@ include file="include/head.jsp" %>
    <body>
        <%@ include file="include/hearder.jsp" %>
        <%@ include file="include/nav.jsp" %>
        <main>
            <form action="#" id="formCadastro" class="inativo">

                <div class="grid">

                <label for="nome">Nome</label>
                <input type="text" name="nome" id="nome" required>

                <label for="registroConselho">Registro</label>
                <input type="text" name="registroConselho" id="registroConselho" required>
                
                <label for="telefone">Telefone</label>
                <input type="tel" name="telefone" id="telefone">
                
                <label for="email">E-mail</label>
                <input type="email" name="email" id="email">
                
                <label for="especialidade">Especialidade</label>
                <select name="especialidade" id="especialidade" required>
                    <option value=""></option>
                    <option value="1">Cardiologia</option>
                    <option value="2">Dermatologia</option>
                    <option value="3">Infectologia</option>
                    <option value="4">Pediatria</option>
                </select>
                
                <label for="unidade">Unidade</label>
                <select name="unidade" id="unidade" required>
                    <option value=""></option>
                    <option value="1">Unidade A</option>
                    <option value="2">Unidade B</option>
                    <option value="3">Unidade C</option>
                </select>

                </div>

                <input type="button" value="Cancelar">
                <input type="submit" value="Salvar">

            </form>
            <jsp:include page="include/comandos.jsp">
                <jsp:param name="link" value="profissionaisForm.jsp" />
            </jsp:include>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Registro</th>
                        <th>Especialidade</th>
                        <th>Unidade</th>
                        <th>Telefone</th>
                        <th>E-mail</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <% for(Profissional item : registros) { %>
                    <tr>
                        <td class="fit"><%=item.getId()%></td>
                        <td><%=item.getNome()%></td>
                        <td><%=item.getRegistroConselho()%></td>
                        <td><%=item.getEspecialidade().getNome()%></td>
                        <td><%=item.getUnidade().getNome()%></td>
                        <td><%=item.getTelefone()%></td>
                        <td><%=item.getEmail()%></td>
                        <td>
                            <a href="javascript:void(0)"
                               class="botao">Editar</a>
                            <a href="profissionais.jsp?excluir=<%=item.getId()%>"
                               class="botao excluir">Excluir</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="8">Total de registros: <%=registros.size()%></td>
                    </tr>
                </tfoot>
            </table>
        </main>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>