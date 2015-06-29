package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import static org.junit.Assert.*;

import tools.Utilities;
import calc.PredicateGenerator;

public class TestSystematicPredicateGenerator {

	@Test
	public void testGeneratesPermutationsCorrectly(){
		int n = 20;
		int k = 7;
		Set<String> allPerms = new HashSet<String>();
		for (int i = 0; i < Utilities.combinations(n, k); i++){
			String result = Arrays.toString(PredicateGenerator.generatePermutationDirections(k, n, i));
			allPerms.add(result);
		}
		assertEquals(Utilities.combinations(n, k), allPerms.size());
	}
	
	@Test
	public void testGeneratePredicateWithNSubPredicatesDeterministically(){
		int v = 4;
		int n = 8 * Utilities.combinations(v, 3);
		int k = 5;
		Set<String> allPerms = new HashSet<String>();
		for (int i = 0; i < Utilities.combinations(n, k); i++){
			String result = Arrays.deepToString(PredicateGenerator.generatePredicateWithNSubPredicatesDeterministically(v, k, i));
			allPerms.add(result);
		}
		assertEquals(Utilities.combinations(n, k), allPerms.size());
	}
}
