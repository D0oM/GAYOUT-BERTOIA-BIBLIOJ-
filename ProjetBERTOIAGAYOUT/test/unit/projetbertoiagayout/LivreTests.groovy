package projetbertoiagayout



import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Livre)
@Mock([Livre,Reservation])
class LivreTests {
	
	@Test
    void testCreation() {
		TypeDocument type = new TypeDocument( intitule : "BD" )
		Livre livre = new Livre( titre : "Tintin", nombreExemplaire : 5, nombreExemplaireDisponible : 5, doc : type )
		assert (livre != null)
		assert (livre.save() != null)
    }
	@Test
	void testCreationBlank() {
		TypeDocument type = new TypeDocument( intitule : "BD" )
		Livre livre = new Livre( titre : "", nombreExemplaire : "", nombreExemplaireDisponible :"",doc : "" )

		assert livre != null
		assert livre.save() == null
	}
	@Test
	void testToString() {
		TypeDocument type = new TypeDocument( intitule : "BD" )
		Livre livre = new Livre( titre : "Tintin", nombreExemplaire : 5, nombreExemplaireDisponible : 5, doc : type )

		assert livre.toString() == "Tintin,5,5"
		
	}
	@Test
	void testaddReservation() {
		TypeDocument type = new TypeDocument( intitule : "BD" )
		Livre livre = new Livre( titre : "Tintin", nombreExemplaire : 5, nombreExemplaireDisponible : 5 , doc : type)
		assert livre != null
		assert livre.save() != null

		assert livre.getNombreExemplaireDisponible() == 5

		Reservation res = new Reservation( code : 1, dateReservation : new Date("22/04/2014") )
		

		livre.addReservation(res)
		assert livre.getNombreExemplaireDisponible() == 4

	}
	
	
	
}
