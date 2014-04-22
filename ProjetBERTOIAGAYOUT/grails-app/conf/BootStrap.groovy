import projetbertoiagayout.Auteur
import projetbertoiagayout.Livre
import projetbertoiagayout.Reservation
import projetbertoiagayout.TypeDocument


class BootStrap {

    def init = { servletContext ->
		TypeDocument type1 = new TypeDocument (intitule : "Nouveaute")
		TypeDocument type2 = new TypeDocument (intitule : "Livre ado")
		TypeDocument type3 = new TypeDocument (intitule : "Livre adulte")
		
		Auteur aut1 = new Auteur( nom : "Vigan", prenom : "Delphine" )
		Auteur aut2 = new Auteur( nom : "Collins", prenom : "Suzanne" )
		Auteur aut3 = new Auteur( nom : "Stockett", prenom : "Kathryn" )
		Auteur aut4 = new Auteur( nom : "Carere", prenom : "Emmanuel" )
		Auteur aut5 = new Auteur( nom : "Murakami", prenom : "Haruki" )
		Auteur aut6 = new Auteur( nom : "Delacourt", prenom : "Gregoire" )
	
		
		Livre livre1 = new Livre( titre : "Rien ne s'oppose a la nuit : roman", nombreExemplaire : 5, nombreExemplaireDisponible : 5, doc : type1 )
		Livre livre2 = new Livre( titre : "La couleur des sentiments", nombreExemplaire : 5, nombreExemplaireDisponible : 5, doc : type1 )
		Livre livre3 = new Livre( titre : "Limonov", nombreExemplaire : 5, nombreExemplaireDisponible : 5, doc : type1 )
		Livre livre4 = new Livre( titre : "1Q84. 1. Avril-juin", nombreExemplaire : 5, nombreExemplaireDisponible : 5, doc : type1 )
		Livre livre5 = new Livre( titre : "1Q84. 3. Octobre-decembre", nombreExemplaire : 5, nombreExemplaireDisponible : 5, doc : type1 )
		Livre livre6 = new Livre( titre : "1Q84. 2. Juillet-septembre", nombreExemplaire : 5, nombreExemplaireDisponible : 5, doc : type1 )
		
		Livre livre7 = new Livre( titre : "Hunger games", nombreExemplaire : 8, nombreExemplaireDisponible : 8, doc : type2 )
		Livre livre8 = new Livre( titre : "L'embrasement", nombreExemplaire : 10, nombreExemplaireDisponible : 10, doc : type2 )
		Livre livre9 = new Livre( titre : "La revolte", nombreExemplaire : 10, nombreExemplaireDisponible : 10, doc : type2 )

		Livre livre10 = new Livre( titre : "La liste de mes envies", nombreExemplaire : 10, nombreExemplaireDisponible : 10 ,doc : type3 )
		
		
		
		aut1.addToLivre(livre1);

		aut2.addToLivre(livre7);
		aut2.addToLivre(livre8);
		aut2.addToLivre(livre9);

		aut3.addToLivre(livre2);

		aut4.addToLivre(livre3);

		aut5.addToLivre(livre4);
		aut5.addToLivre(livre5);
		aut5.addToLivre(livre6);

		aut6.addToLivre(livre10);

		
	
		
		Reservation r1 = new Reservation ( code : 1 , dateReservation : new Date("18/04/2014"))
		livre1.addToReservation(r1)
		
		type1.save()
		type2.save()
		type3.save()
		
		
		aut1.save()
		aut2.save()
		aut3.save()
		aut4.save()
		aut5.save()
		aut6.save()
	
		
		livre1.save()
		livre2.save()
		livre3.save()
		livre4.save()
		livre5.save()
		livre6.save()
		livre7.save()
		livre8.save()
		livre9.save()
		livre10.save()
		
		r1.save()
		
		
		
		
    }
    def destroy = {
    }
}
