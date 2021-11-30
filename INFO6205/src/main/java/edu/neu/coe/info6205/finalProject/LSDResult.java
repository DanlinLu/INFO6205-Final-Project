package edu.neu.coe.info6205.finalProject;

import static edu.neu.coe.info6205.finalProject.readFile.readTxt;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

import edu.neu.coe.info6205.sort.counting.LSDStringSort;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import java.util.Set;

public class LSDResult {
	
	public static double ddoit(Set<String> arrList) {
		LSDStringSort lsd = new LSDStringSort();
		String[] arr = arrList.toArray(new String[arrList.size()]);
		Supplier<String[]> supplier = () -> arr;
		Consumer<String[]> consumer = (f) -> {lsd.sort(arr);};
		Benchmark_Timer<String[]> benchMark = new Benchmark_Timer<String[]>("result",consumer);
		double time = benchMark.runFromSupplier(supplier, 50);
		return time;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] filePathList = {"./shuffledChinese.txt","./shuffledChinese2.txt","./shuffledChinese4.txt","./shuffledChinese3.txt"};
		for (String j : filePathList) {
			HashMap<String,String> content = readTxt(j);
			Set<String> keycontent = content.keySet();
			double meanT = LSDResult.ddoit(keycontent);
			System.out.println(content.size()+"-element file use "+meanT+" ms");
			}

	}

}
