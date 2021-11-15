package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class WQUPCResult {
	
	public static int count(int n) {
		UF_HWQUPC qupc = new UF_HWQUPC(n, false);
		Random rand = new Random();
		int num = 0;
		while(qupc.components() != 1) {
			int r1 = rand.nextInt(n);
	        int r2 = rand.nextInt(n);
	        if (!qupc.connected(r1, r2)) {
	        	qupc.union(r1, r2);
	        }
	        num++;
		}
		return num;
	}
	
	public static void main(String args[]) {
		//int[] n = {20,1000,1100,1200,1300,1400,1500,1600,1700,1800,1900,2000};
		int iteration = 50;
		
		for (int j = 100; j <= 20001; j += 50) {
		int sum = 0;
		for (int i = 0; i < iteration; i++) {
			sum += count(j);
		}
		int res = sum/iteration;
		System.out.println("n: "+j+", "+"average num of pairs: "+res);
		//System.out.println(res);
		}
	}
	

}
