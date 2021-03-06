
public class FibonacciVal {
	
	public static void main (String[] args) {
		
		
		System.out.println(FibonnaciNum(10));
		System.out.println(FibonnaciNum(12));
		System.out.println(fibonacciSum(12));
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
	  public static int fibonacciSum(int n) {
		    if (n < 1) {
		      return 0;
		    }
		    int prevSum = 0;
		    int curSum = 1;
		    for (int i = 1; i < n; i++) {
		      curSum += prevSum;
		      prevSum = curSum - prevSum;
		    }
		    return curSum;
		  }

}
