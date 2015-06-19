DS3Number : DS3Component {
	
	prepare {
		controller.listen (index, this.put (_));
	}

}
