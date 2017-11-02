package cj_store_credit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInput {

	private static final String FILENAME = "E:\\workspace-java\\Java-2016\\PiJ\\google\\store_credit\\A-small-practice.in";

/*	@Test
	public void testCreate() {
		Input input = new Input();
		input.setC(100);
		assertEquals(100,input.getC());
		input.setI(3);
		assertEquals(3,input.getI());
		input.setP("5 75 25");
		assertEquals(3,input.getP().length);
	}
	
	@Test
	public void testCreateInputs(){
		Input[] inputs = StoreCredit.getInputs(FILENAME);
		assertNotNull(inputs);
		for (Input input:inputs){
			assertNotNull(input);
		}
		assertEquals(10,inputs.length);
		assertEquals(100,inputs[0].getC());
		assertEquals(3,inputs[0].getI());
		assertEquals(3,inputs[0].getP().length);
	}*/
	
	@Test
	public void testGetResult(){
		Input[] inputs = StoreCredit.readInputs(FILENAME);
		assertEquals("Case #1: 2 3",inputs[0].toString(0));
		assertEquals("Case #2: 1 4",inputs[1].toString(1));
		assertEquals("Case #3: 4 5",inputs[2].toString(2));
	}

}
