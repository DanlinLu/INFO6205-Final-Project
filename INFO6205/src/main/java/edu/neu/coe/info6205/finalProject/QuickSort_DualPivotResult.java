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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 *
 * @author 60444
 */
public class QuickSort_DualPivotResult {
    
    private static Config config;
    
    public static double ddoit(String filePath) throws IOException {
                config = Config.load();
                Supplier<String> supplier = () -> filePath;
                Consumer<String> consumer = (f) -> {
                    HashMap<String,String> content = readTxt(filePath);// read file and convert Chinese into pinyin in hashmap
                    Set<String> arrList = content.keySet();// set of pinyin
                    String[] arr = arrList.toArray(new String[arrList.size()]);// convert to array
                    QuickSort_DualPivot<String> qs_dualPivot = new QuickSort_DualPivot<>(arr.length,config);
                    String[] xs = qs_dualPivot.sort(arr);
                    List<String> list = new ArrayList<>();//store sorted Chinese
                    for(String s:xs){
                        list.add(content.get(s));
                        //System.out.println(content.get(s)+" : "+s);//print sorted array
                    }
                };
		Benchmark_Timer<String> benchMark = new Benchmark_Timer<String>("result",consumer);
		double time = benchMark.runFromSupplier(supplier, 10);
		return time;
}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
                
		String[] filePathList = {"./shuffledChinese-250k.txt","./shuffledChinese-500k.txt","./shuffledChinese.txt","./shuffledChinese-2M.txt","./shuffledChinese-4M.txt"};
		for (String j : filePathList) {
			double meanT = QuickSort_DualPivotResult.ddoit(j);
                        HashMap<String,String> content = readTxt(j);
			System.out.println(content.size()+"-element file use "+meanT+" ms");
			}
		
	}
}
