package com.coding.tasks.services;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class NextWorkingDayService {
	
	/**
	 *  Returns Next Working Day considering Saturday and Sunday are Holidays
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 * @return
	 */
	public LocalDate calculateNextWorkingDay(int year, int month, int dayOfMonth) {
		LocalDate date = LocalDate.of(year, month, dayOfMonth);
		do {
			date = date.plusDays(1);
		} while(isHoliday(date));
		return date;
	}

	private boolean isHoliday(LocalDate date) {
		return (date.getDayOfWeek() == DayOfWeek.SATURDAY 
				|| date.getDayOfWeek() == DayOfWeek.SUNDAY);
	}
}
