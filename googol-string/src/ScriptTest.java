import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScriptTest {

	@Test
	public void test() {
		int[] testResults= new int[]{0,0,1,0,0,1,1,0,0,0,1,1};
		
		for(int i=1;i < testResults.length+1 ;i++){
			
			System.out.println("Test:"+i);
            assertEquals("Test"+i,"Test"+testResults[i-1],""+Script.getKthValue(i));
		}
	}

}
