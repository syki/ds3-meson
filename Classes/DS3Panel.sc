DS3Panel : DS3Component {
	
	var < stick, < pad, < trigger, < triggers, < button;

	prepare {
		button = DS3Button (controller, index + 1 * 3 + 1);
		stick  = DS3Stick (controller, index);
		pad    = DS3Pad (controller, index + 1 * 8);
		triggers = [
			DS3ButtonWithPressure (controller, index + 14),
			DS3ButtonWithPressure (controller, index + 12),
			stick.trigger
		];
		trigger = [nil] ++ triggers;
	}

}
