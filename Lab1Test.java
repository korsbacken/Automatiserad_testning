package se.iths;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Lab1Test {
	
	Lab1 test;
	
	@Before
	public void defineLab1(){
		test = new Lab1();
	}
	
	@Test
	public void additionTest() {
		int result = test.add(10, 20);
		assertEquals(30, result);
	}
	
	@Test
	public void subtractTest() {
		int result = test.subtract(5, 3);
		assertEquals(2, result);
	}
	
	@Test
	public void multiplyTest() {
		int result = test.multiply(2, 4);
		assertEquals(8, result);
	}
	
	@Test
	public void divideTest() {
		int result = test.divide(10, 5);
		assertEquals(2, result);
	}
	
	@Test
	public void reverseTestTrue() {
		String result = test.reverse("hello");
		assertEquals("olleh", result);
	}
	
	@Test
	public void quoteTest() {
		boolean a = false;
		boolean b = false;
		boolean c = false;
		boolean d = false;
		boolean e = false;
		boolean f = false;
		boolean g = false;
		boolean h = false;
		for (int i = 0; i < 100; i++) {
			String result = test.quote();
			if (result.equals("We cannot solve our problems with the same thinking we used when we created them. - Albert Einstein")) {
			a = true;
			}
			if (result.equals("A fool thinks himself to be wise, but a wise man knows himself to be a fool. - William Shakespeare")) {
			b = true;
			}
			if (result.equals("You must be the change you wish to see in the world. - Mahatma Gandhi")) {
			c = true;
			}
			if (result.equals("In the End, we will remember not the words of our enemies, but the silence of our friends. - Martin Luther King, Jr.")) {
			d = true;
			}
			if (result.equals("Choose a job you love, and you will never have to work a day in your life. - Confucius")) {
			e = true;
			}
			if (result.equals("To expect the unexpected shows a thoroughly modern intellect. - Oscar Wilde")) {
			f = true;
			}
			if (result.equals("Without music, life would be a mistake. - Friedrich Nietzsche")) {
			g = true;
			}
			if (result.equals("I love deadlines. I like the whooshing sound they make as they fly by. - Douglas Adams")) {
			h = true;
			}
		}
		assertTrue(a);
		assertTrue(b);
		assertTrue(c);
		assertTrue(d);
		assertTrue(e);
		assertTrue(f);
		assertTrue(g);
		assertTrue(h);
	}
	
	@Test
	public void getCounterTest() {
		int counterBeforeTest = test.getCounter();
		int methodUsage = 0;
		test.add(1,1);
		methodUsage++;
		test.subtract(1, 1);
		methodUsage++;
		test.divide(1, 1);
		methodUsage++;
		test.multiply(1, 1);
		methodUsage++;
		test.reverse("reverse");
		methodUsage++;
		test.quote();
		methodUsage++;
		assertEquals(methodUsage + counterBeforeTest, test.getCounter());
	}
}