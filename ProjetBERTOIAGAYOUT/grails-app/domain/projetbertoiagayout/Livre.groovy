package projetbertoiagayout

class Livre {
	String titre;
	int nombreExemplaire
	int nombreExemplaireDisponible
	TypeDocument doc
	
	
	static hasMany=[auteur:Auteur, reservation:Reservation]
	static belongsTo = Reservation
	
	static constraints = {
		doc blank:true
    }
	
	String toString() {
		return "Livre [titre=" + titre + ", nombreExemplaire="
				+ nombreExemplaire + ", nombreExemplaireDisponible="
				+ nombreExemplaireDisponible + "]";
	}

	
	void addReservation(Reservation res){
		
		if(nombreExemplaireDisponible >0){
			this.addToReservation(res)
			nombreExemplaireDisponible = nombreExemplaireDisponible -1
			
		}
		else{
			println("Il n'y a plus d'exemplaire en stock")
		}
	}
	
}
