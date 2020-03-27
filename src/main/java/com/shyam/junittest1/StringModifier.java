package com.shyam.junittest1;

public class StringModifier {

	public String truncateAInFirst2Positions(String str) {

		if(str == null || str.length() == 0)
			throw new IllegalArgumentException();
		if (str.length() <= 2 && str.startsWith("A")) {
			str = str.replaceAll("A", "");
		} else {
			if (str.startsWith("A")) {
				String subString1 = str.substring(0, 2);
				String subString2 = str.substring(2);
				subString1 = subString1.replaceAll("A", "");
				str = subString1 + subString2;
			}
		}
		return str;
	}
}
