package interviewbit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * Approach is to find the minimum total of a contiguous subarray of size (A.size() - B) using
 * sliding window so that the remaining elements will automatically have the greatest sum
 * taking B elements from both ends.
 */

public class Array_PickFromBothSides {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputLine = br.readLine().split(" ");
		ArrayList<Integer> A = new ArrayList<>();
		for(String ele: inputLine) A.add(Integer.parseInt(ele));
		
		int B = br.read();
		
		System.out.println(solve(A, B));

	}

	private static int solve(ArrayList<Integer> A, int B) {
		int curSum = 0;
        int totalSum = 0;
        
        // Total sum of the given array
        for(int i=0; i<A.size(); i++) {
            totalSum += A.get(i);
        }
        
        // initiating first set of numbers and getting their sum
        int i=0, j=A.size()-B-1;
        for(int k=i; k<=j; k++) curSum += A.get(k);
        
        int minSum = curSum;
        i++;
        j++;
        
        // Removing first and add last+1 in the window
        // Sliding the window to right by 1.
        while(j<A.size()) {
            curSum += (A.get(j) - A.get(i-1));
            minSum = Math.min(curSum, minSum);
            i++; j++;
        }
        
        return totalSum - minSum;
	}

}
