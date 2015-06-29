package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		TestPredicateEvaluation.class,
		TestPredicateGenerator.class, 
		TestUtilities.class,
		TestVariableVectors.class ,
		TestSystematicPredicateGenerator.class
})

public class TestSuite {

}