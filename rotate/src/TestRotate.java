import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestRotate {

	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
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
