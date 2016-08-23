package com.nufront.euht.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

//@RunWith(SpringJUnit4ClassRunner.class)
public class UuidTest {

	@Test
	public void testCalendar() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startTime = null;
		try {
			startTime = sdf.parse("2016-8-25");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);
		Calendar now = Calendar.getInstance();
		now.setTime(startTime);
		int result = now.compareTo(today);
		System.out.println("today = " + today);
		System.out.println("now = " + now);
		System.out.println("result = " + result);
	}

}
