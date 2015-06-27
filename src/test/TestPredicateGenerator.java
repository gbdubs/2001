package test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import calc.PredicateGenerator;

public class TestPredicateGenerator {

	@Test
	public void testUnsignedVariableChoices(){
		int[][] expected = {
				{1, 1, 1, 0, 0},
				{1, 1, 0, 1, 0},
				{1, 1, 0, 0, 1},
				{1, 0, 1, 1, 0},
				{1, 0, 1, 0, 1},
				{1, 0, 0, 1, 1},
				{0, 1, 1, 1, 0},
				{0, 1, 1, 0, 1},
				{0, 1, 0, 1, 1},
				{0, 0, 1, 1, 1}
		};
		for(int i = 0; i < 10; i++){
			assertArrayEquals(expected[i], PredicateGenerator.generateThreeSatUnsignedSubPredicate(5, i));
		}
	}
}
