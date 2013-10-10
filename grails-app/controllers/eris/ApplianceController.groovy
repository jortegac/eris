package eris

class ApplianceController {

	static scaffold = true

    def index() {
		[applianceInstanceList: Appliance.list()]
	}
}
