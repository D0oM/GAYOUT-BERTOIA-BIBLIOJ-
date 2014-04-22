package projetbertoiagayout



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Reservation)
class ReservationTests {

  void testCreation() {
		TypeDocument type = new TypeDocument( intitule : "BD" )
		Livre livre = new Livre( titre : "Tintin", nombreExemplaire : 5, nombreExemplaireDisponible : 5 , doc : type)
		Reservation res = new Reservation( code : 1, dateReservation : new Date("22/04/2014") )
		assert res != null
		assert res.save() != null
	}

	void testCreationBlank() {
		Reservation res = new Reservation( code : "", dateReservation: "" )
		assert res != null
		assert res.save() == null
	}

	void testToString() {
		Reservation res = new Reservation( code : 1, dateReservation : new Date("22/04/2014") )
		assert res.toString() == "code: 1,"+res.getDateReservation() //"code: "+code+","+dateReservation
	}
}
