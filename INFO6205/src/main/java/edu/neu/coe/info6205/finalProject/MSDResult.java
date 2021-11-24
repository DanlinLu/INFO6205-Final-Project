package edu.neu.coe.info6205.finalProject;

import static edu.neu.coe.info6205.finalProject.readFile.readTxt;

import java.util.HashMap;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

import edu.neu.coe.info6205.sort.counting.MSDStringSort;
import edu.neu.coe.info6205.util.Benchmark_Timer;

public class MSDResult {
	
	public static double ddoit(Set<String> arrList) {
		String[] arr = arrList.toArray(new String[arrList.size()]);
		Supplier<String[]> supplier = () -> arr;
		Consumer<String[]> consumer = (f) -> {MSDStringSort.sort(arr);};
		Benchmark_Timer<String[]> benchMark = new Benchmark_Timer<String[]>("result",consumer);
		double time = benchMark.runFromSupplier(supplier, 50);
		return time;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] filePathList = {"./shuffledChinese2.txt","./shuffledChinese3.txt","./shuffledChinese4.txt"};
		for (String j : filePathList) {
			HashMap<String,String> content = readTxt(j);
			Set<String> keycontent = content.keySet();
			double meanT = MSDResult.ddoit(keycontent);
			System.out.println(content.size()+"-element file use "+meanT+" ms");
			}
		
	}

}
