package tools;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class VariableVectors {

	public static boolean memoize = false;
	private static Map<Integer, Map<Integer, int[]>> memoization = new HashMap<Integer, Map<Integer, int[]>>();

	public static int[] constructDeterministicVector(int nVariables, int seed){	
		if (memoize){
			int[] vector = getMemoizedValue(nVariables, seed);
			if (vector == null){
				vector = calculateVector(nVariables, seed);
				saveMemoizedValue(nVariables, seed, vector);
			}
			return vector;
		}
		return calculateVector(nVariables, seed);
	}
	
	private static int[] calculateVector(int nVariables, int seed){
		int[] result = new int[nVariables];
		int current = 0;
		while (seed > 0){
			result[current] = seed % 2;
			seed = seed / 2;
			current++;
		}
		return result;
	}
	
	private static int[] getMemoizedValue(int nVariables, int seed){
		if (memoization.containsKey(nVariables)){
			Map<Integer, int[]> memoizedVariable = memoization.get(nVariables);
			if (memoizedVariable.containsKey(seed)){
				return memoizedVariable.get(seed);
			}
		}
		return null;
	}
	
	private static void saveMemoizedValue(int nVariables, int seed, int[] vector){
		if (memoization.containsKey(nVariables)){
			Map<Integer, int[]> memoizedVariable = memoization.get(nVariables);
			memoizedVariable.put(seed, vector);
		} else {
			Map<Integer, int[]> memoizedVariable = new HashMap<Integer, int[]>();
			memoizedVariable.put(seed, vector);
			memoization.put(nVariables, memoizedVariable);
		}
	}

	@Test
	/*
	 * Used this test to prove that the memoization is not worth its overhead in this instance.
	 * Opted instead to turn off memoizaiton by default, but kept its functionality in the case that we scale
	 * to larger predicates, where memoization could still hold merit.
	 */
	public void verifyMemoization(){
		VariableVectors.memoize = true;
		int nVariables = 31;
		int maxValue = Utilities.twoPow(nVariables) - 1;
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++){
			VariableVectors.constructDeterministicVector(nVariables, (int) (Math.random() * maxValue));
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++){
			VariableVectors.constructDeterministicVector(nVariables, (int) (Math.random() * maxValue));
		}
		long time3 = System.currentTimeMillis();
		System.out.println("Time for initial calls: " + (time2 - time1));
		System.out.println("Time for memoized calls: " + (time3 - time2));
		assertTrue(time2 - time1 > time3 - time2);
	}
	
}
