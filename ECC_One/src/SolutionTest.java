
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SolutionTest {
	
	private Solution sol;

	@Before
	public void setUp() throws Exception {
		sol = new Solution(10);
	}

	@Test
	public void testBasicObjectCreation() {
		assertNotNull("Basic object creation", sol);
		assertEquals("Object type", sol.getClass(), Solution.class);
	}
	
	@Test
	public void testSampleSequence() {
		sol.append("Fee");
		sol.append("Fi");
		sol.append("Fo");
		
		sol.append("Fum");
		
		sol.remove();
		sol.remove();
		
		assertTrue("Estimated output for sequence", sol.list().equals(new String("Fo\nFum\n")));		
	}

}
