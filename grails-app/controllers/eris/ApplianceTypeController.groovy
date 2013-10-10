package eris

class ApplianceTypeController {

	static scaffold = true

    def index() { 
		[applianceTypeInstanceList : ApplianceType.list()]
	}
}
