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
		Livre livre3 = new Livre (titre : "Metro2", nombreExemplaire : 5, nombreExemplaireDisponible : 5 ,doc : type1 )
		Livre livre4 = new Livre (titre : "Metro3", nombreExemplaire : 5, nombreExemplaireDisponible : 5 ,doc : type1 )
		Livre livre5 = new Livre (titre : "Metro4", nombreExemplaire : 5, nombreExemplaireDisponible : 5 ,doc : type1 )
		Livre livre6 = new Livre (titre : "Metro5", nombreExemplaire : 5, nombreExemplaireDisponible : 5 ,doc : type1 )
		Livre livre7 = new Livre (titre : "Metro6", nombreExemplaire : 5, nombreExemplaireDisponible : 5 ,doc : type1 )
		
		
		aut1.addToLivre(livre1)
		aut1.addToLivre(livre2)
		aut1.addToLivre(livre3)
		aut1.addToLivre(livre4)
		aut1.addToLivre(livre5)
		aut1.addToLivre(livre6)
		aut1.addToLivre(livre7)
		
		Reservation r1 = new Reservation ( code : 1 , dateReservation : new Date("18/04/2014"))
		
		type1.save()
		aut1.save()
		livre1.save()
		livre2.save()
		livre3.save()
		livre4.save()
		livre5.save()
		livre6.save()
		livre7.save()
		
		
		
		
		
		
    }
    def destroy = {
    }
}
