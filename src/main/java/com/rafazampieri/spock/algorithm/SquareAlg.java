package com.rafazampieri.spock.algorithm;

public class SquareAlg {

	/**
	 * A perfect square is an integer that is the square of any integer. For
	 * example, 1, 4, 9 and 16 are some of the perfect square númeos since they
	 * are, respectively, the square of 1, 2, 3 and 4.
	 * 
	 * @param valueA
	 * @param valueB
	 * @return countPerfectSquare
	 */
	public Integer countPerfectSquareInRange(Integer valueA, Integer valueB) {
		Double sqrt1 = Math.sqrt(valueA);
		int valueASquare = sqrt1.intValue();

		Double sqrt2 = Math.sqrt(valueB);
		int valueBSquare = sqrt2.intValue();

		return valueBSquare - valueASquare;
	}

}
