package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tools.Utilities;
import tools.VariableVectors;

public class TestVariableVectors {

	@Test
	public void testThreeVariableVectors(){
		int[][] expected = {
				{-1, -1, -1}, { 1, -1, -1}, {-1,  1, -1}, { 1,  1, -1}, 
				{-1, -1,  1}, { 1, -1,  1}, {-1,  1,  1}, { 1,  1,  1}
		};
		for (int i = 0; i < expected.length; i++){
			assertArrayEquals(expected[i], VariableVectors.constructDeterministicVector(3, i));
		}	
	}
	
	@Test
	public void testRandomVectorsAgainstBinaryStringMethodology(){
		int nVariables = 18;
		int maxValue = Utilities.twoPow(nVariables) - 1;
		for (int i = 0; i < 1000; i++){
			int seed = (int) (Math.random() * maxValue);
			int[] expectation = constructExpectationUsingStringMethods(nVariables, seed);
			int[] actual = VariableVectors.constructDeterministicVector(nVariables, seed);
			assertArrayEquals(expectation, actual);
		}
	}
	
	
	private static int[] constructExpectationUsingStringMethods(int desiredLength, int seed){
		int[] result = new int[desiredLength];
		for(int i = 0; i < result.length; i++){
			result[i] = -1;
		}
		char[] fromBinary = Integer.toBinaryString(seed).toCharArray();
		int index = 0;
		for (int i = fromBinary.length - 1; i >= 0; i--){
			int positive = fromBinary[i] - 48;
			if (positive == 1){
				result[index++] = 1;
			} else {
				result[index++] = -1;
			}
		}
		return result;
	}
	
}
