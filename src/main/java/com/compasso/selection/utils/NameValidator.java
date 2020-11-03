package com.compasso.selection.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator {
	public static boolean isNameValid(String name) {
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(name);
	
		return (name == null || name.isEmpty() || matcher.find()) ? false : true;
	}

}
