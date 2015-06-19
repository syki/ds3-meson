DS3Stick : DS3Component {

	var < trigger;

	initialValue {
		^ Point (0, 0);
	}

	prepare {
		var currentPoint = this.initialValue;

		controller.listen (index * 2) { |x|
			currentPoint.x = x.madd (2, -1);
			this.put (currentPoint);
		};

		controller.listen (index * 2 + 1) { |y|
			currentPoint.y = y.madd (-2, 1);
			this.put (currentPoint);
		};

		trigger = DS3Button (controller, index + 5);
	}

}
