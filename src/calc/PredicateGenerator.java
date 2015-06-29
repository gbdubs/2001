package calc;

import java.util.Arrays;

import tools.Utilities;

public class PredicateGenerator {

	public static int[][] generatePredicateWithNSubPredicatesDeterministically(int nVariables, int nSubPredicates, int seed){
		int nPossibleSubPredicates = 8 * nVariables * (nVariables - 1) * (nVariables - 2) / 6;
		
		int[] subPredicateSeeds = generatePermutationDirections(nSubPredicates, nPossibleSubPredicates, seed);
		int[][] result = new int[nSubPredicates][3];
		for (int i = 0; i < nSubPredicates; i++){
			result[i] = generateThreeSatSignedSubPredicate(nVariables, subPredicateSeeds[i]);
		}
		return result;
	}
	
	public static int[] generatePermutationDirections(int k, int n, int seed){
		int[] directions = new int[k];
		
		int current = 1;
		int index = 0;
		while (index < directions.length){
			if (seed < Utilities.combinations(n - current, k - index - 1)){
				directions[index++] = current - 1;
			} else {
				seed -= Utilities.combinations(n - current, k - index - 1);
			}
			current++;
		}

		return directions;
	}
	
	public static int[] generateThreeSatSignedSubPredicate(int nVariables, int seed){
		int signDescription = seed % 8;
		boolean firstNegative = signDescription / 4 == 1;
		boolean secondNegative = (signDescription / 2) % 2 == 1;
		boolean thirdNegative = signDescription % 2 == 1;
		
		int variableAssignmentDescription = seed / 8;
		int[] result = generateThreeSatUnsignedSubPredicate(nVariables, variableAssignmentDescription);
		int numVariables = 0;
		for(int i = 0; i < result.length; i++){
			if (result[i] == 1){
				if (numVariables == 0 && firstNegative){	
					result[i] = -1;
				} else if (numVariables == 1 && secondNegative){
					result[i] = -1;
				} else if (numVariables == 2 && thirdNegative){
					result[i] = -1;
				}
				numVariables++;
			}
		}
		return result;
	}
	
	public static int[] generateThreeSatUnsignedSubPredicate(int nVariables, int seed){
		int[] result = new int[nVariables];
		int current = 0;
		int remaining = nVariables - 1;
		int count = 0;
		while (count == 0){
			if (seed < (remaining * (remaining - 1))/2){
				result[current] = 1;
				count++;
			} else {
				seed -= (remaining * (remaining - 1))/2;
			}
			current++;
			remaining--;
		}
		while (count == 1){
			if (seed < remaining){
				result[current] = 1;
				count++;
			} else {
				seed -= remaining;
			}
			current++;
			remaining--;
		}
		while (count == 2){
			if (seed < 1){
				result[current] = 1;
				count++;
			} else {
				seed -= 1;
			}
			current++;
			remaining--;
		}
		return result;
		
	}
	
}
