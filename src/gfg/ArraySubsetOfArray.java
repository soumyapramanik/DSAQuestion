package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ArraySubsetOfArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		while(T-- > 0) {
			String[] sizes = br.readLine().trim().split(" ");
			int m = Integer.parseInt(sizes[0]);
			int n = Integer.parseInt(sizes[1]);
			int[] arr1 = new int[m];
			int[] arr2 = new int[n];
			String[] inputLine1 = br.readLine().split(" ");
			for(int i=0; i<m; i++) arr1[i] = Integer.parseInt(inputLine1[i]);
			String[] inputLine2 = br.readLine().split(" ");
			for(int i=0; i<n; i++) arr2[i] = Integer.parseInt(inputLine2[i]);
			
			solve(arr1, arr2, m, n);
		}
		
	}

	private static void solve(int[] arr1, int[] arr2, int m, int n) {
		HashSet<Integer> hs = new HashSet<Integer>();
		Boolean isSubset = true;
		for(int num: arr1) hs.add(num);
		for(int num: arr2) {
			if(!hs.contains(num)) {
				isSubset = false;
				break;
			}
		}
		if(isSubset) System.out.println("Yes");
		else System.out.println("No");
	}

}
