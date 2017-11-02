package src;

public class Script {
	
	public static void  main(String...args){
		// To Do....
	}
	
	
	public static int getKthValue(int k){
		int k1 = 0;
		int k2 = 0;
		if (k>3){
			k1 = getPower2KBound(true,k);
			k2 = getPower2KBound(false,k);
			System.out.println(String.format("%d lower %d, upper %d",k,k1,k2));			
		}

		if (2*k == k1+k2){
			return 0;
		} else if(-2*k == k1+k2 ){
			return 1;
		}
		
		switch(k){
		case -1 :
		case -2 :
			return 1;
		case -3 :
			return 0;
		case 0 :
		case 1 :
		case 2 :
			return 0;
		case 3 :
			return 1;
		default:		
			return	getKthValue((2*k > k1+k2)? k - k2 : k - k1);
		}
			
	}
	
	
	private static int getPower2KBound(boolean isLowerBound, int k) {
		int power2 = 1;
		while(power2*2 < k){
			power2 = 2*power2;
		}
		return (isLowerBound)?power2:power2*2;
	}


}
