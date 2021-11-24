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
import edu.neu.coe.info6205.sort.linearithmic.QuickSort_DualPivot;
import edu.neu.coe.info6205.util.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class QuickSort_DualPivotApply {
    
    private static Config config;
    
    public static void main(String[] args) throws IOException{
        config = Config.load();
        /*
        String[] xs = new String[5];
        xs[0] = "zhang kun   hui   ";
        xs[1] = "lu    dan   lin   ";
        xs[2] = "yang  wen   qi    ";
        xs[3] = "wang  kun   lun   ";
        xs[4] = "wang  jun   lun   ";
*/
        String filePath = "D:/temp/shuffledChinese.txt";   
        HashMap<String,String> content = readTxt(filePath);  
        String[] xs = new String[content.size()];
        content.keySet().toArray(xs);
        QuickSort_DualPivot<String> qs_dualPivot = new QuickSort_DualPivot<>(xs.length,config);
        Timer timer = new Timer();
        double mean = timer.repeat(10, () -> {
            qs_dualPivot.sort(xs);
            return null;
        });
        System.out.println("running time : "+mean+" millisecends");
        String[] result = qs_dualPivot.sort(xs);
        for(int i = 0;i<content.size();i+=100)
            System.out.println(result[i]+":"+content.get(result[i]));
    }
}
