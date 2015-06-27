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
	
	public static int combinations(int n, int k){
		long result = 1L;
		int remainingDivisions = n - k;
		for (int i = n; i > k; i--){
			while (remainingDivisions > 1 && result % (remainingDivisions) == 0){
				result = result / remainingDivisions;
				remainingDivisions--;
			}
			result *= i;
		}
		while (remainingDivisions > 1 && result % (remainingDivisions) == 0){
			result = result / remainingDivisions;
			remainingDivisions--;
		}
		return (new Long(result)).intValue();
	}
}
