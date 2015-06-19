DS3 {

	classvar all, < match;

	var < hid, < hidInfo, < hidProto;
	
	var < left, < right;
	var < selectButton, < startButton;
	var < dPad, < directionalPad;
	var < shapes, < shapePad;
	var < triangleButton, < circleButton, < crossButton, < squareButton;

*	initClass {
		match = IdentityDictionary.new;
		match[1356] = Set[ 616, 627 ];
	}

*	new { |hid|
		^ if (hid.isNil) { this.first } { super.new.hid_ (hid).initialize };
	}

*	findAllHIDInfos {
		^ HID.findAvailable.values.select { |hidInfo|
			var m = match[hidInfo.vendorID];
			m.notNil and: { m.includes (hidInfo.productID) };
		};
	}

*	findAllHIDs {
		^ this.findAllHIDInfos.collect (_.open);
	}

*   findAll {
		^ this.findAllHIDs.collect (this.new (_));
	}

*	all {
		^ all ?? { all = this.findAll };
	}

*	any {
		^ this.first;
	}

*	first {
		^ this.all.first;
	}

*	second {
		^ this.all.second;
	}

*	third {
		^ this.all.third;
	}

	hid_ { |value|
		hid = value;
		hidInfo = value.info;
		hidProto = value.asHIDProto;
	}

	listen { |index, function|
		HIDFunc.proto (function, hid.elements[index].asHIDElementProto, hidProto).permanent_ (true);
	}

	initialize {
		left  = DS3Panel (this, 0);
		right = DS3Panel (this, 1);
		
		selectButton = left.button; startButton  = right.button;
		
		dPad = directionalPad = left.pad;
		shapes = shapePad = right.pad;
		
		triangleButton = shapes.top;
		squareButton   = shapes.left;
		circleButton   = shapes.right;
		crossButton    = shapes.bottom;
	}

}
