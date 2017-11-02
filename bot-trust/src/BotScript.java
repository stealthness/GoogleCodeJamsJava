package src;

public class BotScript {

	private static final String input = "src//bot_trust//A-large-practice.in";
	private static final String output = "src//bot_trust//A-large-practice.out";
	private static final int testLength = 4;

	public static void main(String[] args) {
		Test[] tests = getTests(input);
		createOutput(tests,output);
	}

	private static void createOutput(Test[] tests, String output2) {
		int count = 0;
		for (Test test:tests){
			System.out.println("Case #"+(count++)+" "+test.getResult());
		}
	}

	private static Test[] getTests(String filename) {
		//Test[] test = null;
		Test[] tests = new Test[1];
		String[] colorSeq = new String[]{"orange","blue","blue","orange"};
		Bot[] bots = new Bot[]{	
				new Bot("blue", new int[]{1,2}),
				new Bot("orange", new int[]{2,4})
				};	
		tests[0] = new Test(colorSeq, bots);
		
		return tests;
	}

}

class Test{

	private static final int TIME_OUT = 2000;
	String[] colorSeq;
	Bot[] bots;

	int currentColorSeq = 0;
	int time = 0;
	boolean atEnd = false;
	boolean changeSeq = false;	
	
	
	public Test(String[] colorSeq, Bot[] bots) {	
		this.colorSeq = colorSeq;
		this.bots = bots;
	}
	
	public int getResult(){
		while (!atEnd && time < TIME_OUT){
			changeSeq = false;
			for(Bot bot:bots){
				bot.move();
			}
			atEnd = bots[0].isFinished() && bots[1].isFinished();
			currentColorSeq =+ ((changeSeq)?1:0);		
			time++;
		}
		return time;
	}
	
	
}


class Bot{
	int pos = 1;
	int currentSeq = 0;
	String color;
	int[] btnSeq;
	boolean isWaiting = false;
	
	
	public Bot(String color, int[] btnSeq) {
		this.color = color;
		this.btnSeq = btnSeq;
	}
	
	public void push() {	
		if (currentSeq < btnSeq.length-1 ){
			System.out.println("push("+color+")");
			currentSeq++;
		}else{
			boolean isWaiting = false;
		}	
	}

	public String getColor() {
		return color;
	}

	public boolean isWaiting() {
		return isWaiting;
	}

	void move(){
		
		if (isWaiting && pos == btnSeq[currentSeq]){
			push();
			System.out.println("push("+color+") at:"+pos);
		}
		if (!isWaiting){
			pos = (btnSeq[currentSeq]<pos)?pos-1:pos+1;
			System.out.println("move("+color+") to pos:"+pos);
		}
		
		if (pos == btnSeq[currentSeq]){
			isWaiting = true;
			System.out.println("move("+color+") waiting at:"+pos);
		}
	}
	
	boolean isFinished(){
		
		System.out.println("Finished("+color+") waiting at:"+pos);
		return isWaiting && currentSeq == btnSeq.length-1;		
	}
	
}
