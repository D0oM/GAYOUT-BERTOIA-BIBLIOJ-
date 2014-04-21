<%@ page import="projetbertoiagayout.Auteur" %>



<div class="fieldcontain ${hasErrors(bean: auteurInstance, field: 'livre', 'error')} ">
	<label for="livre">
		<g:message code="auteur.livre.label" default="Livre" />
		
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: auteurInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="auteur.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${auteurInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: auteurInstance, field: 'prenom', 'error')} ">
	<label for="prenom">
		<g:message code="auteur.prenom.label" default="Prenom" />
		
	</label>
	<g:textField name="prenom" value="${auteurInstance?.prenom}"/>
</div>

