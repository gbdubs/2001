package calc;

import java.util.Arrays;

import tools.Utilities;

public class PredicateGenerator {

	private static int[][] generateNSubPredicatesDeterministically(int nVariables, int nSubPredicates, int seed){
		int nPossibleSubPredicates = 8 * nVariables * (nVariables - 1) * (nVariables - 2) / 3;
		
		int[] subPredicateSeeds = new int[nSubPredicates];
		
		int current = 0;
		
		for(int i = 0; i < subPredicateSeeds.length; i++){
			if (seed < Utilities.combinations(nPossibleSubPredicates, nSubPredicates - i)){
				
			} else {
				seed -= Utilities.combinations(nPossibleSubPredicates, nSubPredicates - i);
			}
			
			
		}
		return null;
		
	}
	

	
	public static int[] generateSubPredicateSeeds(int nSubPredicates, int nPossibleSubPredicates, int seed){
		int[] subPredicateSeeds = new int[nSubPredicates];
		
		int current = 0;
		
		for(int i = 0; i < subPredicateSeeds.length; i++){
			if (seed < Utilities.combinations(nPossibleSubPredicates, nSubPredicates - i)){
				subPredicateSeeds[i] = current;
			} else {
				seed -= Utilities.combinations(nPossibleSubPredicates, nSubPredicates - i);
			}
			current++;
			
			
		}
		return subPredicateSeeds;
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
	public static void main(String[] args){
		int total = Utilities.combinations(80, 4);
		for(int i = 0; i < total; i++){
			System.out.println(Arrays.toString(generateSubPredicateSeeds(4, 80, i)));
			if (i == 200){
				break;
			}
		}
	}
	
	
}
