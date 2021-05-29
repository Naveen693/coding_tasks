package com.coding.tasks.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class NextWorkingDayServiceTest {

	@Test
	public void testNextWorkingDay() {
		LocalDate nextWorkingDay = new NextWorkingDayService().calculateNextWorkingDay(2021, 5, 29);
		assertEquals(DayOfWeek.MONDAY, nextWorkingDay.getDayOfWeek());
		assertEquals(31, nextWorkingDay.getDayOfMonth());
		assertEquals(5, nextWorkingDay.getMonth().getValue());
		assertEquals(2021, nextWorkingDay.getYear());
	}
}
