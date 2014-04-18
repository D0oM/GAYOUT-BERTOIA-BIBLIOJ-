import projetbertoiagayout.Auteur
import projetbertoiagayout.Livre
import projetbertoiagayout.Reservation
import projetbertoiagayout.TypeDocument


class BootStrap {

    def init = { servletContext ->
		TypeDocument type1 = new TypeDocument (intitule : "Journal")
		
		Auteur aut1 = new Auteur ( nom : "Bertoia" , prenom :"Mathieu")
		
		Livre livre1 = new Livre (titre : "La depeche", nombreExemplaire : 3, nombreExemplaireDisponible : 3 ,doc : type1 )
		Livre livre2 = new Livre (titre : "Metro", nombreExemplaire : 5, nombreExemplaireDisponible : 5 ,doc : type1 )
		
		aut1.addToLivre(livre1)
		aut1.addToLivre(livre2)
		
		Reservation r1 = new Reservation ( code : 1 , dateReservation : new Date("18/04/2014"))
		
		type1.save()
		aut1.save()
		livre1.save()
		livre2.save()
		
		
		
		
		
    }
    def destroy = {
    }
}
