
<%@ page import="projetbertoiagayout.Livre" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'livre.label', default: 'Livre')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-livre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="list" action="listRecherche"><g:message code="recherche" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-livre" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<form name="ajouterPanier" action="list" method="get">
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="titre" title="${message(code: 'livre.titre.label', default: 'Titre')}" />
					
						<g:sortableColumn property="nombreExemplaire" title="${message(code: 'livre.nombreExemplaire.label', default: 'Nombre Exemplaire')}" />
					
						<g:sortableColumn property="nombreExemplaireDisponible" title="${message(code: 'livre.nombreExemplaireDisponible.label', default: 'Nombre Exemplaire Disponible')}" />
						<th><g:message code="livre.doc.label" default="Doc" /></th>
					
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${livreInstanceList}" status="i" var="livreInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${livreInstance.id}">${fieldValue(bean: livreInstance, field: "doc")}</g:link></td>
					
						<td>${fieldValue(bean: livreInstance, field: "nombreExemplaire")}</td>
					
						<td>${fieldValue(bean: livreInstance, field: "nombreExemplaireDisponible")}</td>
					
						<td>${fieldValue(bean: livreInstance, field: "titre")}</td>
						
						<td>
 								<%
 									String boutonAjouter = ""
 									if(livreInstance.nombreExemplaireDisponible>0)
 										boutonAjouter = '<button name="idLivre" type="submit" value="' + livreInstance.id +'">Ajouter</button>'
 								 %>
 								${boutonAjouter}
 							</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			
			</form>
			<div class="pagination">
				<g:paginate total="${livreInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
