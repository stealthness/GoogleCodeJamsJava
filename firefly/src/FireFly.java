public class FireFly {
	
	double[] pos;
	double[] vel;
	
	public FireFly(double x, double y, double z, double vx, double vy, double vz){
		this.pos = new double []{x,y,z};
		this.vel = new double []{vx,vy,vz};	
	}
	
	public FireFly(String string) {
		String[] values = string.split(" ");
		this.pos = new double []{Double.parseDouble(values[0]),Double.parseDouble(values[1]),Double.parseDouble(values[2])};
		this.vel = new double []{Double.parseDouble(values[3]),Double.parseDouble(values[4]),Double.parseDouble(values[5])};	
	}

	public void moveT(double time){
		pos = new double[] {pos[0]+time*vel[0],pos[1]+time*vel[1],pos[2]+time*vel[2]};
	}
	
	public String toString(){
		return pos[0]+","+pos[1]+","+pos[2];
	}

	public double[] getPos() {
		return pos;
	}
}
