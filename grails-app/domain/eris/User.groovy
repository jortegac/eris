package eris

class User {

	static hasMany = [appliances: Appliance]

	String name
	String email
	String password
	Integer age
	String gender
	Date dateCreated
	Date lastUpdated
	
    static constraints = {
		name size: 5..45, blank: false
		age nullable: true, blank: true
		gender nullable: true, blank: true
		email size: 5..50, email: true, blank: false
		password size: 6..32, blank: false        
    }
	
	String toString() {
		return name
	}
}
