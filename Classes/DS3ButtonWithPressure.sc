DS3ButtonWithPressure : DS3Button {

	var < pressure;

	prepare {
		super.prepare;
		pressure = DS3Pressure (controller, index + 21);
	}

}
