package edu.neu.coe.info6205.finalProject;

import edu.neu.coe.info6205.huskySort.sort.huskySort.PureHuskySort;
import edu.neu.coe.info6205.huskySort.sort.huskySortUtils.HuskyCoderFactory;
import edu.neu.coe.info6205.sort.counting.LSDStringSort;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.HashMap;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static edu.neu.coe.info6205.finalProject.readFile.readTxt;

public class huskyResult {
    public static double ddoit(Set<String> arrList) {
        PureHuskySort<String> sorter = new PureHuskySort<>(HuskyCoderFactory.englishCoder, false, false);
        String[] arr = arrList.toArray(new String[arrList.size()]);
        Supplier<String[]> supplier = () -> arr;
        Consumer<String[]> consumer = (f) -> {
            sorter.sort(arr);};
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
            double meanT = huskyResult.ddoit(keycontent);
            System.out.println(content.size()+"-element file use "+meanT+" ms");


        }

    }
}
