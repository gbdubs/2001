package test;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import tools.Utilities;

public class TestUtilities {

	@Test
	public void testBasicCombinations(){
		assertEquals(10, Utilities.combinations(5, 3));
		assertEquals(10, Utilities.combinations(5, 2));
		assertEquals(20, Utilities.combinations(20, 19));
		assertEquals(20, Utilities.combinations(20, 1));
	}
	
	@Test
	public void testAdvancedCombinations(){
		assertEquals(6435, Utilities.combinations(15, 8));
		assertEquals(170544, Utilities.combinations(22, 7));
		assertEquals(bruteCombinations(80, 6), Utilities.combinations(80, 6));
		assertEquals(bruteCombinations(120, 7), Utilities.combinations(120, 7));
		assertEquals(bruteCombinations(60, 8), Utilities.combinations(60, 8));
	};
	
	public static int bruteCombinations(int n, int k){
		return ((bruteFactorial(n)).divide(bruteFactorial(k)).divide(bruteFactorial(n-k))).intValue();
	}
	
	public static BigInteger bruteFactorial(int n){
		BigInteger result = BigInteger.ONE;
		for (int i = 2; i <= n; i++){
			result = result.multiply(BigInteger.valueOf((long) i));
		}
		return result;
	}
}
