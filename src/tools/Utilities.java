package tools;

import java.math.BigInteger;

public class Utilities {

	public static int twoPow(int exponent){
		return (int) Math.pow(2, exponent);
	}
	
	public static long longTwoPow(int exponent){
		return (long) Math.pow(2, exponent);
	}
	
	public static BigInteger bigTwoPow(int exponent){
		return BigInteger.valueOf(2L).pow(exponent);
	}
}
