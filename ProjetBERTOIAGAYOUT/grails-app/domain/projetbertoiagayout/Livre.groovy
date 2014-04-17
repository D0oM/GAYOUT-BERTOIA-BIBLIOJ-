package projetbertoiagayout

class Livre {
	String titre;
	int nombreExemplaire
	int nombreExemplaireDisponible
	TypeDocument doc
	
	
	static hasMany=[auteur:Auteur, reservation:Reservation]
	
	
	static constraints = {
		doc blank:true
    }
	
	String toString() {
		return "Livre [titre=" + titre + ", nombreExemplaire="
				+ nombreExemplaire + ", nombreExemplaireDisponible="
				+ nombreExemplaireDisponible + "]";
	}

	
}
