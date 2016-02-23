/*
 * Russell Walton
 * 
 * Purpose: an algorithm to compute and print all prime numbers between 2 and n (inclusive)
 */

import java.util.Scanner;


public class ComputePrimes {

	public static void main(String[] args) {
		int max, primeCount, primesIndex, topPrimes;
		boolean[] primeCheck;
		int[] allInts, primeInts;
		String primeList;
		long startTime, endTime;
		
		Scanner input = new Scanner(System.in);
		
		//take user input for the max value
		System.out.println("Calculate all primes up to: ");
		while (!input.hasNextInt()) 
			input.next();
		max = input.nextInt();
		
		//computation time start point
		startTime = System.nanoTime();
		
		primeCheck = new boolean[max + 1];
		primeCount = 0;
		primesIndex = 0;
		primeList = "";
		allInts = new int[max-2];
	    	for(int i = 0; i<allInts.length;i++)
	    	{
	    		allInts[i] = (i+2);
	    	}
	    primeInts = new int[max];
		

    	
        for (int i = 2; i <= max; i++) 
        {
            primeCheck[i] = true;
        }

        //set non-prime indexes of primeCheck matrix to false
        for (int i = 2; i*i <= max; i++) 
        {
            if (primeCheck[i]) 
            {
                for (int j = i; j*i <= max; j++) 
                {
                    primeCheck[j*i] = false;
                }
            }
        }

        
        // populates primeInts matrix with the primes up to input max & counts them
        for(int i = 0; i<=max-2;i++)
        {
        	if(primeCheck[i+2])
        	{
        		primeInts[primesIndex] = allInts[i];
        		primesIndex++;
        		primeCount++;
        	}
        }
        
        // adds the top 50 prime numbers to the primeList String for output
        topPrimes = 50;
        for(int i = primeInts.length-1;i>=0;i--)
        {	
        	if(topPrimes > 0)
        	{
	        	if(primeInts[i] != 0)
	        	{
	        		primeList += primeInts[i] +" ";
	        		topPrimes--;
	        		if(topPrimes == 25)
	        			primeList += "\n";
	        	}
        	}
        }
        
        //computation time end point
        endTime = System.nanoTime();
        
        System.out.println("Given n = " + max);
        System.out.println("Numbers of primes is: " + primeCount);
        System.out.println("Top 50 prime numbers: ");
        System.out.println(primeList);
        System.out.println("Elapsed time: " + (endTime - startTime) + " nanoseconds");
    }

}


