package calc;

import tools.Utilities;
import tools.VariableVectors;

public class PredicateManipulator {

	public static String evaluate(int[][] predicate){
		int nSubpredicates = predicate.length;
		if (nSubpredicates == 0){
			return "";
		}
		int nVariables = predicate[0].length;		
		char[] result = new char[Utilities.twoPow(nVariables)];
		
		for (int i = 0; i < result.length; i++){
			int[] vector = VariableVectors.constructDeterministicVector(nVariables, i);
			// Converts the integer result to its character equivalent.
			result[i] = (char) (48 + evaluatePredicateWithVector(predicate, vector));
		}
		
		return String.copyValueOf(result);
	}
	
	public static int evaluatePredicateWithVector(int[][] predicate, int[] vector){
		for (int[] subPredicate : predicate){
			boolean subSatisfied = false;
			for (int variable = 0; variable < vector.length; variable++){
				if (subPredicate[variable] == vector[variable] && vector[variable] != 0){
					subSatisfied = true;
					break;
				}
			}
			if (! subSatisfied){
				return 0;
			}
		}
		return 1;
	}
}
