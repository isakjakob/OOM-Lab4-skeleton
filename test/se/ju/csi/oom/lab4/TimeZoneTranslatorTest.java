package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		DateTime theDate = new DateTime(2018, 3, 16, 1, 0, 0);
		DateTime theDateShifted = new DateTime(2018, 3, 16, 13, 0, 0);
		
		assertEquals(TimeZoneTranslator.shiftTimeZone(theDate, 0, 12).toString(), theDateShifted.toString());
	}

	@Test
	public void testShiftTimeZone2() {
		DateTime theDate = new DateTime(2016, 1, 1, 6, 0, 0);
		DateTime theDateShifted = new DateTime(2015, 12, 31, 21, 0, 0);
		
		assertEquals(TimeZoneTranslator.shiftTimeZone(theDate, 0, -9).toString(), theDateShifted.toString());
	}
	
	@Test
	public void testShiftEventTimeZone() {
		DateTime startTime = new DateTime(1993, 16, 03, 16, 0, 0);
		DateTime endTime = new DateTime(1993, 16, 03, 20, 0, 0);
		
		Person myMom = new Person("Sigridur");
		Person myDad = new Person("Hafthor");
		
		Place myHouse = new Place("Svöluklettur", 64.55, -21.9, 5.0);
		
		Event birthdayParty = new Event("Birthday", startTime, endTime, new HashSet<>(Arrays.asList(myMom, myDad)), myHouse);
		
		DateTime startTimeShifted = new DateTime(1993, 16, 03, 12, 0, 0);
		DateTime endTimeShifted = new DateTime(1993, 16, 03, 16, 0, 0);
		
		Event birthdayPartyShifted = new Event("Birthday", startTimeShifted, endTimeShifted, new HashSet<>(Arrays.asList(myMom, myDad)), myHouse);
		
		assertEquals(TimeZoneTranslator.shiftEventTimeZone(birthdayParty, TimeZone.GREENWICH_UTC, TimeZone.HALIFAX).toString(), birthdayPartyShifted.toString());
	}
	
	@Test
	public void testDateTimeString() {
		DateTime theDate2 = new DateTime(2018, 6, 17, 12, 0, 0);
		DateTime theDate3 = new DateTime("\\\\2\\\\0\\\\1\\\\8)-(\\\\0\\\\6)-(\\\\1\\\\7) (\\\\1\\\\2):(\\\\0\\\\0):(\\\\0\\\\0");
		
		assertEquals(theDate2.toString(), theDate3.toString());
	}

}
