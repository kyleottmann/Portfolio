package rsaCipherDemo;

import java.util.Arrays;
import java.util.Scanner;

public class RSACipherDemo {

	public static void main(String[] args) {
		
		//Read in prime numbers from user
		Scanner in = new Scanner(System.in);
		int prime1 = in.nextInt();
		int prime2 = in.nextInt();
		in.close();
		
		//Create N
		int n = (prime1 * prime2);
		
		//Create totient
		int tot = ((prime1 - 1) * (prime2 - 1));
		
		//Determine Public Key e
		int e = 3;
		
		while ((tot % e) == 0) {
			e++;
		}
		
		//Build Equation
		String equation = (e + "*d(mod " + tot + ") = 1");
		
		//Get private key d
		int[] ans = new int[3];
		ans = ExtendedEuclid(e, tot);
		int d = ans[1];
		if (d < 0) { d = (tot + d); }
		
		//Encrypt Message
		int m = 2;
		double enc = ((Math.pow(m, e)) % n);
		
		//Decrypt Message
		double dec = ((Math.pow(enc, d)) % n);
		
		//Print All
		System.out.println("prime1: " + prime1);
		System.out.println("prime2: " + prime2);
		System.out.println("n: " + n);
		System.out.println("totient: " + tot);
		System.out.println("e: " + e);
		System.out.println("equation: " + equation);
		System.out.println("Extened Euclidean: " + Arrays.toString(ans));
		System.out.println("Private key d: " + d);
		System.out.println("encryped message: " + enc);
		System.out.println("decrypted message: " + dec);
		
	}
	
	public static int[] ExtendedEuclid(int a, int b)
	    /*  This function will perform the Extended Euclidean algorithm
	        to find the GCD of a and b.  We assume here that a and b
	        are non-negative (and not both zero).  This function also
	        will return numbers j and k such that 
	               d = j*a + k*b
	        where d is the GCD of a and b.
	    */
	    { 
	        int[] ans = new int[3];
	        int q;

	        if (b == 0)  {  /*  If b = 0, then we're done...  */
	            ans[0] = a;
	            ans[1] = 1;
	            ans[2] = 0;
	        }
	        else
	            {     /*  Otherwise, make a recursive function call  */ 
	               q = a/b;
	               ans = ExtendedEuclid (b, a % b);
	               int temp = ans[1] - ans[2]*q;
	               ans[1] = ans[2];
	               ans[2] = temp;
	            }

	        return ans;
	    }

}
