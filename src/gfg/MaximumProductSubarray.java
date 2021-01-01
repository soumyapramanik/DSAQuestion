package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumProductSubarray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			String[] inputLine = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(inputLine[i]);
			}
			
			System.out.println(maxProduct(arr, n));
		}

	}
	
	public static long maxProduct(int[] arr, int n) {
		long maxprod = arr[0];
		long minprod = arr[0];
		long res = arr[0];
		
		for(int i=1; i<n; i++) {
			if(arr[i] < 0) {
				maxprod = maxprod + minprod;
                minprod = maxprod - minprod;
                maxprod = maxprod - minprod;
			}
			maxprod = Math.max(arr[i], arr[i]*maxprod);
            minprod = Math.min(arr[i], arr[i]*minprod);
            
            res = Math.max(res, maxprod);
		}
		
		return res;
	}

}
