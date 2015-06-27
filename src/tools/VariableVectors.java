package tools;

import java.util.HashMap;
import java.util.Map;

public class VariableVectors {

	private static Map<Integer, Map<Integer, int[]>> memoization = new HashMap<Integer, Map<Integer, int[]>>();

	public static int[] constructDeterministicVector(int nVariables, int seed){	
		int[] vector = getMemoizedValue(nVariables, seed);
		if (vector == null){
			vector = calculateVector(nVariables, seed);
			saveMemoizedValue(nVariables, seed, vector);
		}
		return vector;
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

}
