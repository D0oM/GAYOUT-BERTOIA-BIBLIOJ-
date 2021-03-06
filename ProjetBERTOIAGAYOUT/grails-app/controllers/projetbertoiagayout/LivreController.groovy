package projetbertoiagayout

import org.springframework.dao.DataIntegrityViolationException

class LivreController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max,Integer idLivre) {
       
		if (session["panier"]==null)
		
			session["panier"]=[]
			
		session["panier"].add(Livre.findById(idLivre))
			
		params.max = Math.min(max ?: 5, 100)
        [livreInstanceList: Livre.list(params), livreInstanceTotal: Livre.count()]
    }
	
	def listRecherche(Integer max,Integer idLivre) {
		
		if (session["panier"]==null)
		
			session["panier"]=[]
			
		session["panier"].add(Livre.findById(idLivre))
		params.max = Math.min(max ?: 5, 100)
		//[livreFiltre: Livre.findAllByTitreLike("%d%"), livreInstanceTotal: Livre.findAllByTitre("La depeche").count(null)]
		
				def typeRecherche = params.type
				def auteurRecherche = params.auteur
				def titreRecherche = params.titre
		
		
				if(typeRecherche == null)
					typeRecherche = ""
				if(auteurRecherche == null)
					auteurRecherche = ""
				if(titreRecherche == null)
					titreRecherche = ""
		
				def criteria = Livre.createCriteria()
				def results = criteria.listDistinct {
					'in'("doc", TypeDocument.findAllByIntituleLike("%" + typeRecherche + "%"))
					auteur{
						like("nom", "%"+auteurRecherche+"%")
					}
					like("titre", "%"+titreRecherche+"%")
					order("titre","asc")
		
		
		
				}
		
				[livreFiltre: results, livreInstanceTotal: results.count(null), listeDesTypes: TypeDocument.list()]
			 }
	
	
    def create() {
        [livreInstance: new Livre(params)]
    }

    def save() {
        def livreInstance = new Livre(params)
        if (!livreInstance.save(flush: true)) {
            render(view: "create", model: [livreInstance: livreInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'livre.label', default: 'Livre'), livreInstance.id])
        redirect(action: "show", id: livreInstance.id)
    }

    def show(Long id) {
        def livreInstance = Livre.get(id)
        if (!livreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'livre.label', default: 'Livre'), id])
            redirect(action: "list")
            return
        }

        [livreInstance: livreInstance]
    }

    def edit(Long id) {
        def livreInstance = Livre.get(id)
        if (!livreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'livre.label', default: 'Livre'), id])
            redirect(action: "list")
            return
        }

        [livreInstance: livreInstance]
    }

    def update(Long id, Long version) {
        def livreInstance = Livre.get(id)
        if (!livreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'livre.label', default: 'Livre'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (livreInstance.version > version) {
                livreInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'livre.label', default: 'Livre')] as Object[],
                          "Another user has updated this Livre while you were editing")
                render(view: "edit", model: [livreInstance: livreInstance])
                return
            }
        }

        livreInstance.properties = params

        if (!livreInstance.save(flush: true)) {
            render(view: "edit", model: [livreInstance: livreInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'livre.label', default: 'Livre'), livreInstance.id])
        redirect(action: "show", id: livreInstance.id)
    }

    def delete(Long id) {
        def livreInstance = Livre.get(id)
        if (!livreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'livre.label', default: 'Livre'), id])
            redirect(action: "list")
            return
        }

       
            livreInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'livre.label', default: 'Livre'), id])
            redirect(action: "list")
   
    }
	
	
	def viderPanier() {
				session["panier"] = []
				def targetUri = params.targetUri ?: "/"
				redirect(uri: targetUri)
			}
		
	def deleteLivrePanier(Integer idItem){
				for(int i = 1; session["panier"] != null && i<session["panier"].size(); i++){
					if(session["panier"][i] != null && session["panier"][i].getId() == idItem){
						session["panier"].remove(i)
						def targetUri = params.targetUri ?: "/"
						redirect(uri: targetUri)
						return(0)
					}
				}
			}
	
}
