
public class FibonacciVal {
	
	public static void main (String[] args) {
		
		
		System.out.println(FibonnaciNum(15));
		
		System.out.println("all doneski");
	}
	
	//returns the fibonacci sequence to the nth term
	
	public static int FibonnaciNum(int i) {
		int p2, p1, fibVal, passedVal;
		p2 = 0;
		p1 = 0;
		fibVal = 0;
		passedVal = i;
		//indexing requires passedVal > 1, not 0 as predicted
		while (passedVal > 1){
			p2 = p1;
			p1 = fibVal;
			fibVal = p1 + p2;
			if(p1 == 0) {
				p1 += 1;
			}
			passedVal -= 1;
		}
		return fibVal;
		
	}

}
