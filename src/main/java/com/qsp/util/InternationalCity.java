package com.qsp.util;

import java.util.LinkedHashSet;
import java.util.Set;

public enum InternationalCity {
	DELHI, LONDON, WASHINGTON, MELBORN, AUKLAND, BRBADOS, TOKYO, BEJING, MOSKO, 
	KATHAMANDU, NEWYORK, DUBBLIN, PARIS, ROME, VATICAN, MANACO, MADRID, BARSALONA;

	public static Set<String> getCities() {
		Set<String> cityNames = new LinkedHashSet<>();
		for (InternationalCity city: InternationalCity.values())
			cityNames.add(city.name());
		return cityNames;
	}
}
