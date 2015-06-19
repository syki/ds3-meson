DS3Pad : DS3Component {
	
	var < button, < buttons;
	var < triangle, < circle, < cross, < square;
	var < north, < east, < south, < west;
	var < left, < right;
	var < top, < bottom;
	var < up, < down;

	prepare {
		buttons = (0..3).collect { |i| DS3ButtonWithPressure (controller, index + i) };
		button = [nil] ++ buttons;

		north = top = up = triangle = button[1];
		east = right = circle = button[2];
		south = bottom = down = cross = button[3];
		west = left = square = button[4];
	}

}
