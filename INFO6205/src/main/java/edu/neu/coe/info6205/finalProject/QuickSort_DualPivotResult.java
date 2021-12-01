/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.finalProject;

import static edu.neu.coe.info6205.finalProject.readFile.readTxt;
import edu.neu.coe.info6205.sort.linearithmic.QuickSort_DualPivot;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Config;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 *
 * @author 60444
 */
public class QuickSort_DualPivotResult {
    
    private static Config config;
    
    public static double ddoit(Set<String> arrList) throws IOException {
                config = Config.load();
		String[] arr = arrList.toArray(new String[arrList.size()]);
        Supplier<String[]> supplier = () -> arr;
        Consumer<String[]> consumer = (f) -> {
        QuickSort_DualPivot<String> qs_dualPivot = new QuickSort_DualPivot<>(arr.length,config);
        qs_dualPivot.sort(arr);
                };
		Benchmark_Timer<String[]> benchMark = new Benchmark_Timer<String[]>("result",consumer);
		double time = benchMark.runFromSupplier(supplier, 50);
		return time;
}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
                
		String[] filePathList = {"./shuffledChinese.txt"};
		for (String j : filePathList) {
			HashMap<String,String> content = readTxt(j);
                        Set<String> keycontent = content.keySet();
			double meanT = QuickSort_DualPivotResult.ddoit(keycontent);
			System.out.println(content.size()+"-element file use "+meanT+" ms");
			}
		
	}
}
