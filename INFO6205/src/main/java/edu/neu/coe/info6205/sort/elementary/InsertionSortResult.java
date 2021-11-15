package edu.neu.coe.info6205.sort.elementary;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

import edu.neu.coe.info6205.util.Benchmark_Timer;

public class InsertionSortResult {

	public static double ddoit(int N, int type) {
			InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
			Supplier<Integer[]> supplier = () -> arr(N,type);
			Consumer<Integer[]> consumer = (f) -> {insertionSort.sort(f,0,f.length);};
			Benchmark_Timer<Integer[]> benchMark = new Benchmark_Timer<Integer[]>("result",consumer);
			//benchMark.run(arr(N,type), 10);
			double time = benchMark.runFromSupplier(supplier, 10);
			return time;
	}

	private static Integer[] arr(int n, int type) {
		Integer[] arr1 = new Integer[n];
		if(type == 1)
		{
			for(int i = 0; i < n; i++)
			{
				arr1[i] = (int) (Math.random()*10000);
			}
			/*
			System.out.println("arr1 0: "+arr1[0]);
			System.out.println("arr1 1: "+arr1[1]);
			*/
			
		}
		else if(type == 2)
		{
			for(int i = 0; i < n; i++)
			{
				arr1[i] = i;
			}
		}
		else if(type == 3)
		{
			for(int i = 0; i < n; i++)
			{
				if(i < n / 2) arr1[i] = (int) (Math.random()*10000);
				else arr1[i] = i;
			}
		}
		else
		{
			for(int i = 0; i < n; i++)
			{

				arr1[i] = n - i;
			}
		}	
		return arr1;
	} 

	public static void main(String[] args) {
		int[] nList = {500,1000,2000,4000,8000,16000,32000,64000};
		ArrayList<Double> meanTimeList = new ArrayList<Double>();
		for (int i = 1; i < 5; i++) {
			if (i == 1) System.out.println("type: Random");
			else if (i == 2) System.out.println("type: Ordered");
			else if (i == 3) System.out.println("type: Partially-Ordered");
			else System.out.println("type: Reverse-Ordered");
			for (int j : nList) {
				double meanT=InsertionSortResult.ddoit(j, i);
				meanTimeList.add(meanT);
			}
			for (double k : meanTimeList) {
				System.out.println(k);
			}
			meanTimeList.clear();
		}
	}
}

