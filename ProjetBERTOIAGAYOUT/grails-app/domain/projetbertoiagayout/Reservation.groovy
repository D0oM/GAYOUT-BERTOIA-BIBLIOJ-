package projetbertoiagayout

class Reservation {

	int code;
	Date dateReservation;
	static hasMany=[reservation:Reservation]
	static belongsTo= Livre
    static constraints = {
    }
}
