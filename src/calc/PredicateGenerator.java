package calc;

import java.util.Arrays;

public class PredicateGenerator {

	private static int[][] generateNSubPredicatesDeterministically(int nVariables, int seed){
		return null;
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
		for(int i = 0; i < 10; i++){
			System.out.println(Arrays.toString(generateThreeSatUnsignedSubPredicate(5, i)));
		}
	}
	
	
}
