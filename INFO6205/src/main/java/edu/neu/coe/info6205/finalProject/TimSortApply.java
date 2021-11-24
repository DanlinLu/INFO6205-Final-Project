/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.finalProject;

/**
 *
 * @author 60444
 */
import static edu.neu.coe.info6205.finalProject.readFile.readTxt;
import edu.neu.coe.info6205.sort.*;
import edu.neu.coe.info6205.sort.linearithmic.TimSort;
import edu.neu.coe.info6205.util.*;
import java.io.IOException;
import java.util.HashMap;

public class TimSortApply {
    
    private static Config config;
    
    public static void main(String[] args) throws IOException{
        config = Config.load();
        String filePath = "D:/temp/shuffledChinese.txt";   
        HashMap<String,String> content = readTxt(filePath);  
        String[] xs = new String[content.size()];
        String[] xs1 = new String[content.size()];
        content.keySet().toArray(xs);
        content.keySet().toArray(xs1);
                
        //timsort.sort(xs,0,xs.length);
        
        Timer timer = new Timer();
        double mean = timer.repeat(10, () -> {
            //xs = Arrays.copy(xs1);
            TimSort<String> timsort = new TimSort<>(xs.length,config);
            timsort.sort(xs,0,xs.length);
            return null;
        });
        System.out.println("running time : "+mean+" millisecends");
        for(int i = 0;i<content.size();i+=100)
            System.out.println(xs[i]+":"+content.get(xs[i]));
    }
}
