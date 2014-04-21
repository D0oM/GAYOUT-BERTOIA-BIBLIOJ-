
<%@ page import="projetbertoiagayout.Livre" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'livre.label', default: 'Livre')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-livre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-livre" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list livre">
			
				<g:if test="${livreInstance?.doc}">
				<li class="fieldcontain">
					<span id="doc-label" class="property-label"><g:message code="livre.doc.label" default="Doc" /></span>
					
						<span class="property-value" aria-labelledby="doc-label"><g:link controller="typeDocument" action="show" id="${livreInstance?.doc?.id}">${livreInstance?.doc?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${livreInstance?.auteur}">
				<li class="fieldcontain">
					<span id="auteur-label" class="property-label"><g:message code="livre.auteur.label" default="Auteur" /></span>
					
						<g:each in="${livreInstance.auteur}" var="a">
						<span class="property-value" aria-labelledby="auteur-label"><g:link controller="auteur" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${livreInstance?.nombreExemplaire}">
				<li class="fieldcontain">
					<span id="nombreExemplaire-label" class="property-label"><g:message code="livre.nombreExemplaire.label" default="Nombre Exemplaire" /></span>
					
						<span class="property-value" aria-labelledby="nombreExemplaire-label"><g:fieldValue bean="${livreInstance}" field="nombreExemplaire"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${livreInstance?.nombreExemplaireDisponible}">
				<li class="fieldcontain">
					<span id="nombreExemplaireDisponible-label" class="property-label"><g:message code="livre.nombreExemplaireDisponible.label" default="Nombre Exemplaire Disponible" /></span>
					
						<span class="property-value" aria-labelledby="nombreExemplaireDisponible-label"><g:fieldValue bean="${livreInstance}" field="nombreExemplaireDisponible"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${livreInstance?.reservation}">
				<li class="fieldcontain">
					<span id="reservation-label" class="property-label"><g:message code="livre.reservation.label" default="Reservation" /></span>
					
						<g:each in="${livreInstance.reservation}" var="r">
						<span class="property-value" aria-labelledby="reservation-label"><g:link controller="reservation" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${livreInstance?.titre}">
				<li class="fieldcontain">
					<span id="titre-label" class="property-label"><g:message code="livre.titre.label" default="Titre" /></span>
					
						<span class="property-value" aria-labelledby="titre-label"><g:fieldValue bean="${livreInstance}" field="titre"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${livreInstance?.id}" />
					<g:link class="edit" action="edit" id="${livreInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
