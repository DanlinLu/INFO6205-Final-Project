/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.finalProject;

import static edu.neu.coe.info6205.finalProject.WriteFile.writeFile;
import static edu.neu.coe.info6205.finalProject.readFile.readTxt;
import edu.neu.coe.info6205.huskySort.sort.huskySort.PureHuskySort;
import edu.neu.coe.info6205.huskySort.sort.huskySortUtils.HuskyCoderFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author 60444
 */
public class huskyOutput {
    public static void main(String[] args) throws IOException{
        String filePath = "./shuffledChinese.txt";   
        HashMap<String,String> content = readTxt(filePath);  
        String[] xs = new String[content.size()];
        content.keySet().toArray(xs);
        
        PureHuskySort<String> sorter = new PureHuskySort<>(HuskyCoderFactory.englishCoder, false, false);
        sorter.sort(xs);
        
        List<String> list = new ArrayList<>();
        for(String s:xs){
            list.add(content.get(s));
            System.out.println(content.get(s)+" : "+s);
        }
        String path = "./SortedResultOfHusky.txt";
        writeFile(list,path);
        System.out.println(list.size()+" elements has saved into "+path);
    }
}
