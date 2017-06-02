package org.garatea.server.model;

public enum ContactType {
	GENERIC(1),
	PARTNER(2),
	VOLUNTEER(3),
	HUB(4);
	
	final private int numVal;

	ContactType(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
