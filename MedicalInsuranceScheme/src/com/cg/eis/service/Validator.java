package com.cg.eis.service;

public interface Validator {
	String eidpattern="[1-9][0-9]{2}";
	String namepattern="[A-Z][a-zA-Z ']*";
	String salpattern="[1-9][0-9].*";
	public static boolean validatedata(String data,String pattern)
	{
		return data.matches(pattern);
	}
}