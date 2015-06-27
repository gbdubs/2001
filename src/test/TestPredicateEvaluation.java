package test;

import static org.junit.Assert.*;

import org.junit.Test;

import calc.PredicateManipulator;

public class TestPredicateEvaluation {

	@Test
	public void testSingleSubPredicate(){
		int[][] predicate = {{-1, 0, 0, 1, 1}};
		int[] vector1 = {0, 1, 1, 0, -1};
		int[] vector2 = {1, 0, 0, 1, -1};
		int[] vector3 = {1, 0, 1, -1, -1};
		int[] vector4 = {-1, -1, -1, 0, -1};
		int[] vector5 = {0, -1, 1, 0, 0};
		int[] vector6 = {0, 0, 0, 0, 0};
		
		assertEquals(0, PredicateManipulator.evaluatePredicateWithVector(predicate, vector1));
		assertEquals(1, PredicateManipulator.evaluatePredicateWithVector(predicate, vector2));
		assertEquals(0, PredicateManipulator.evaluatePredicateWithVector(predicate, vector3));
		assertEquals(1, PredicateManipulator.evaluatePredicateWithVector(predicate, vector4));
		assertEquals(0, PredicateManipulator.evaluatePredicateWithVector(predicate, vector5));
		assertEquals(0, PredicateManipulator.evaluatePredicateWithVector(predicate, vector6));
	}
	
	@Test
	public void testSinglePredicateEvaluation(){
		int[][] predicate1 = {{1, -1, 0}, {-1, 0, 0}, {1, 0, 1}};
		String expected1 = "00001000";
		assertEquals(expected1, PredicateManipulator.evaluate(predicate1));
		
		int[][] predicate2 = {{0, -1, 1}, {-1, 1, 0}, {1, 0, -1}};
		String expected2 = "10000001";
		assertEquals(expected2, PredicateManipulator.evaluate(predicate2));
	}
	
	
}
