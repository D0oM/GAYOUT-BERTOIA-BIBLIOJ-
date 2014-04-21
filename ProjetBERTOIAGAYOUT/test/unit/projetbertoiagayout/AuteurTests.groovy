package projetbertoiagayout



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Auteur)
class AuteurTests {
	
	@Test
    void testCreation() {
       Auteur a = new Auteur(nom:"Bertoia", prenom:"Mathieu")
	   assert (a != null)
	   assert (a.save() != null)
    }
	@Test
	void testBlank(){
		Auteur a = new Auteur(nom:"", prenom:"")
		assert (a != null)
		assert (a.save() == null)
	}
	@Test
	void testToString(){
		Auteur a = new Auteur(nom:"Bertoia",prenom:"Mathieu")
		assert (a.toString() == "Bertoia Mathieu")
	}
}
