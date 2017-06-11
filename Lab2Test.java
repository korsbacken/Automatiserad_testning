package se.iths;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class Lab2Test {

	static MeasureConverter mesCon;
	static TimeConverter 	timeCon;
	static Americanizer 	americanizer;

	@BeforeClass
	public static void defineLab2Test() {
		
		mesCon			= new MeasureConverter();
		timeCon			= new TimeConverter();
		americanizer	= new Americanizer();
		americanizer.setWeightConverter(mesCon);
		americanizer.setTimeConverter(timeCon);
	}

	@Test
	public void counterWeightTestKgs() {
		assertEquals("Convert to kg´s", 10, mesCon.convertWeight(27, true));
	}

	@Test
	public void counterWeightTestPounds () {
		assertEquals("Convert to pounds", 27, mesCon.convertWeight(10, false));
	}

	@Test	
	public void convertToFeetTest () {
		assertEquals("Convert to feet", 1, mesCon.convertToFeet(30));
	}

	@Test
	public void getMeridiemTestAM() {
		assertEquals("Convert to 12-hour AM", "AM", timeCon.getMeridiem(11));
	}

	@Test
	public void getMeridiemTestPM() {
		assertEquals("Convert to 12-hour PM", "PM", timeCon.getMeridiem(12));
	}

	@Test(expected = IllegalArgumentException.class)
	public void getMeridiemThrowsExceptionTest() {
		String result = timeCon.getMeridiem(24);	
	}

	@Test(expected = IllegalArgumentException.class)
	public void getMeridiemThrowsException() {
		String result = timeCon.getMeridiem(-1);
	}

	@Test(expected = NullPointerException.class)
	public void counterWeightNullTest() {
		int result = mesCon.convertWeight((Integer) null, true);
	}

	@Test
	public void convertSpeachTest() {
		assertEquals("check speachConverter", "yo dude! Awsome, you know?", americanizer.convertSpeach(" Awsome"));
	}

	@Test
	public void convertToFeetIntegrationTest(){
		assertEquals("check convertToFeet integration", 1, americanizer.convertToFeet(30));		
	}

	@Test
	public void converToPoundIntegrationTest() {
		assertEquals("check convertToPound integration", 10, americanizer.convertToPound(27));
	}

	@Test
	public void convertTimeIntegrationTest() {
		assertEquals("check timeConverter integration", 9 + " PM", americanizer.convertTime(21));
	}
	
	@Test
	public void convertTimeIntegrationTest2() {
		assertEquals("check timeConverter integration", 9 + " AM", americanizer.convertTime(9));
	}

}
