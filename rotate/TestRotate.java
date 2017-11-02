import org.junit.*;

import static org.junit.Assert.*;

public class TestRotate {

	@org.junit.Before
	public void setUp() throws Exception {
	}

	@org.junit.Test
	public void testLine() {
		Line line = new Line("RRBB",2);
		assertEquals("RRBB", line.toString());
		assertTrue(line.isWinK("B"));
		assertTrue(line.isWinK("R"));
		
		line = new Line("..RR.BB.",2);
		assertEquals("..RR.BB.", line.toString());
		assertTrue(line.isWinK("B"));
		assertTrue(line.isWinK("R"));
		
		line = new Line("..RRR.BB.",3);

		assertEquals("..RRR.BB.", line.toString());
		assertFalse(line.isWinK("B"));
		assertTrue(line.isWinK("R"));
	}

}
