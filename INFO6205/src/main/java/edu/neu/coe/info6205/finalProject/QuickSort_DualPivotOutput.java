/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.finalProject;

import static edu.neu.coe.info6205.finalProject.WriteFile.writeFile;
import static edu.neu.coe.info6205.finalProject.readFile.readTxt;
import edu.neu.coe.info6205.sort.linearithmic.QuickSort_DualPivot;
import edu.neu.coe.info6205.sort.linearithmic.TimSort;
import edu.neu.coe.info6205.util.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author 60444
 */
public class QuickSort_DualPivotOutput {
    private static Config config;
    public static void main(String[] args) throws IOException{
        config = Config.load();
        String filePath = "./shuffledChinese.txt";   
        HashMap<String,String> content = readTxt(filePath);  
        String[] xs = new String[content.size()];
        content.keySet().toArray(xs);
        
        QuickSort_DualPivot<String> qs_dualPivot = new QuickSort_DualPivot<>(xs.length,config);
        xs = qs_dualPivot.sort(xs);
        
        List<String> list = new ArrayList<>();
        for(String s:xs){
            list.add(content.get(s));
            System.out.println(content.get(s)+" : "+s);
        }
        String path = "./SortedResultOfQuickSort_DualPivot.txt";
        writeFile(list,path);
        System.out.println(list.size()+" elements has saved into "+path);
    }
}
