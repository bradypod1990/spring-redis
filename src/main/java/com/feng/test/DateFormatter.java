package com.feng.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {

	private String pattern;

	public DateFormatter(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public String print(Date date, Locale locale) {
		return this.getDateFormat(locale).format(date);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		return this.getDateFormat(locale).parse(text);
	}

	protected DateFormat getDateFormat(Locale locale) {
		if(locale == null) {
			locale = Locale.CHINA;
		}
		DateFormat dateFormat = new SimpleDateFormat(this.pattern, locale);
		dateFormat.setLenient(false);
		return dateFormat;
	}

}
