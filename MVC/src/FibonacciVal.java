
public class FibonacciVal {
	
	public static void main (String[] args) {
		
		
		System.out.println(FibonnaciNum(15));
		
		System.out.println("all doneski");
	}
	
	//returns the fibonacci sequence to the nth term
	
	public static int FibonnaciNum(int i) {
		int val = 1;
		
		if (i == 1 || i == 2) {
			return 1;
		}
		else if (i > 2) {
			return FibonnaciNum(i - 1) + FibonnaciNum(i - 2);
		}
		return 0;
		
	}

}
