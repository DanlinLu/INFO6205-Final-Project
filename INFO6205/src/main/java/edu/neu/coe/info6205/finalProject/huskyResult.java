package edu.neu.coe.info6205.finalProject;

import static edu.neu.coe.info6205.finalProject.readFile.readTxt;
import edu.neu.coe.info6205.huskySort.sort.huskySort.PureHuskySort;
import edu.neu.coe.info6205.huskySort.sort.huskySortUtils.HuskyCoderFactory;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import java.io.IOException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import java.util.Set;

public class huskyResult {
    public static double ddoit(String filePath) {
		Supplier<String> supplier = () -> filePath;
		Consumer<String> consumer = (f) -> {
                    HashMap<String,String> content = readTxt(filePath);// read file and convert Chinese into pinyin in hashmap
                    Set<String> arrList = content.keySet();// set of pinyin
                    String[] arr = arrList.toArray(new String[arrList.size()]);// convert to array
                    PureHuskySort<String> sorter = new PureHuskySort<>(HuskyCoderFactory.englishCoder, false, false);
                    sorter.sort(arr);   
                    List<String> list = new ArrayList<>();//store sorted Chinese
                    for(String s:arr){
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
            double meanT = huskyResult.ddoit(j);
                        HashMap<String,String> content = readTxt(j);
            System.out.println(content.size()+"-element file use "+meanT+" ms");


        }

    }
}
