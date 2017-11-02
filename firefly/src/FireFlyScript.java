import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FireFlyScript {

	private static final String FILENAME = "out//production//firefly//B-small-practice.in";

	public static void main(String[] args) {
		
		Swarm[] swarms = getSwarms(FILENAME);
		System.out.println(getSwarmDistance(swarms[0]));
		swarms[0].move(10);
		System.out.println(getSwarmDistance(swarms[0]));
		swarms[0].move(-10);
		double[] guess = new double[]{0,getSwarmDistance(swarms[0])};
		double d0 = getSwarmDistance(swarms[0]);
		System.out.println(d0);
		swarms[0].move(10);
		double d1 = getSwarmDistance(swarms[0]);
		double[] nextGuess = new double[]{10,d1};
		for (int i= 0;i<20;i++){
			double ratio = d1/d0;
			if (nextGuess[1]< guess[1]){
				guess = nextGuess;
				swarms[0].move(nextGuess[0]*ratio);
				nextGuess = new double[]{nextGuess[0]*ratio,getSwarmDistance(swarms[0])};
			}else{
				swarms[0].move(nextGuess[0]/ratio);
				nextGuess = new double[]{nextGuess[0]/ratio,getSwarmDistance(swarms[0])};
			}
			System.out.println(getSwarmDistance(swarms[0]));			
		}
		System.out.println(nextGuess[0]+ " "+ nextGuess[1]);

		
				
	}
	
	public static Swarm[] getSwarms(String filename){
		Swarm[] swarms = null;
		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			int count = Integer.parseInt(br.readLine());
			swarms = new Swarm[count];
			while (count>0){
				int noFlies = Integer.parseInt(br.readLine());
				FireFly[] flies = new FireFly[noFlies];
				while (noFlies>0){
					flies[noFlies-1] = new FireFly(br.readLine());
					noFlies--;
				}
				swarms[count-1] = new Swarm(flies);
				count--;
			}
		} catch ( IOException e) {
			e.printStackTrace();
		}
		return swarms;
	}
	
	public static Swarm createSwarm(String[] flyDetails){
		int length = flyDetails.length;
		FireFly[] flies = new FireFly[length];
		for (int i = 0; i<length;i++){
			flies[i] = new FireFly(flyDetails[i]);
		}
		return new Swarm(flies);
	}
	
	public static double getSwarmDistance(Swarm swarm){
		double[] c = swarm.getCenter();
		return Math.sqrt(c[0]*c[0]+c[1]*c[1]+c[2]*c[2]);
		
	}

	
}
