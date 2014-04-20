Livre.findById(1)<%@ page import="projetbertoiagayout.Livre" %>



<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'doc', 'error')} required">
	<label for="doc">
		<g:message code="livre.doc.label" default="Doc" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="doc" name="doc.id" from="${projetbertoiagayout.TypeDocument.list()}" optionKey="id" required="" value="${livreInstance?.doc?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'auteur', 'error')} ">
	<label for="auteur">
		<g:message code="livre.auteur.label" default="Auteur" />
		
	</label>
	<g:select name="auteur" from="${projetbertoiagayout.Auteur.list()}" multiple="multiple" optionKey="id" size="5" value="${livreInstance?.auteur*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'nombreExemplaire', 'error')} required">
	<label for="nombreExemplaire">
		<g:message code="livre.nombreExemplaire.label" default="Nombre Exemplaire" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="nombreExemplaire" type="number" value="${livreInstance.nombreExemplaire}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'nombreExemplaireDisponible', 'error')} required">
	<label for="nombreExemplaireDisponible">
		<g:message code="livre.nombreExemplaireDisponible.label" default="Nombre Exemplaire Disponible" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="nombreExemplaireDisponible" type="number" value="${livreInstance.nombreExemplaireDisponible}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'reservation', 'error')} ">
	<label for="reservation">
		<g:message code="livre.reservation.label" default="Reservation" />
		
	</label>
	<g:select name="reservation" from="${projetbertoiagayout.Reservation.list()}" multiple="multiple" optionKey="id" size="5" value="${livreInstance?.reservation*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'titre', 'error')} ">
	<label for="titre">
		<g:message code="livre.titre.label" default="Titre" />
		
	</label>
	<g:textField name="titre" value="${livreInstance?.titre}"/>
</div>

