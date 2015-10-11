package com.rafazampieri.spock;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

// https://github.com/junit-team/junit/wiki/Parameterized-tests
@RunWith(value= Parameterized.class)
public class MathUtilsTest {
	
	private int a;
	private int b;
	private int expected;

	public MathUtilsTest(int a, int b, int expected) {
		this.a = a;
		this.b = b;
		this.expected = expected;
	}

	@Test
	public void add() {
		MathUtils mathUtils = new MathUtils();
		
		assertTrue( mathUtils.add(a, b) == expected);
	}
	
	@Parameters(name = "{index}: add( {0}, {1} ) = {2}")
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][]{
				{1, 2, 3},
				{5, 6, 11}
		});
	}

}
