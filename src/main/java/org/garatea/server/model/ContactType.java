package org.garatea.server.model;

public enum ContactType {
	GENERIC(0),
	PARTNER(1),
	VOLUNTEER(2),
	HUB(3);
	
	final private int numVal;

	ContactType(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
