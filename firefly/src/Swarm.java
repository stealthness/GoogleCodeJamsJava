import java.util.ArrayList;
import java.util.List;

public class Swarm {
	
	List<FireFly> swarm;
	
	
	public Swarm(FireFly[] flies){
		swarm = new ArrayList<>();
		for (FireFly fly:flies){
			swarm.add(fly);
		}
	}
	
	public double[] getCenter(){
		double[] center = new double[3];
		for (FireFly fly:swarm){
			double[] pos = fly.getPos();
			center[0] =center[0]+ pos[0];
			center[1] =center[1]+ pos[1];
			center[2] =center[2]+ pos[2];
		}
		double number = swarm.size();
		center[0] = center[0]/number ;
		center[1] = center[1]/number ;
		center[2] = center[2]/number ;
		return center;
		
	}

	public void move(double time) {
		for (FireFly fly:swarm){
			fly.moveT(time);
		}
	}
	

}
