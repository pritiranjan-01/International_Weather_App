package com.qsp.util;
public enum SubscriptionType {
	GO, PRO, MAX;

	public static SubscriptionType getUserSubscriptionType(int ordinal) {
		switch (ordinal) {
		case 0:
			return PRO;
		case 1:
			return MAX;
		case 2:
			return GO;
	    default : return GO;
		}
	}

	public static String[] getAllTypes() {
		return new String[] { GO.name(), PRO.name(), MAX.name() };
	}
}