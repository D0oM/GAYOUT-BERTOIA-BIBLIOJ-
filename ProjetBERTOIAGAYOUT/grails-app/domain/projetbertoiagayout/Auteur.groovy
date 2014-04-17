package projetbertoiagayout

class Auteur {

	String nom
	String prenom
	static hasMany=[livre:Livre]
	static belongsTo= Livre
	
	
	
    static constraints = {
		
    }
}
