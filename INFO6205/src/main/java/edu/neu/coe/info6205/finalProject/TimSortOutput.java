/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.finalProject;

import static edu.neu.coe.info6205.finalProject.WriteFile.writeFile;
import static edu.neu.coe.info6205.finalProject.readFile.readTxt;
import edu.neu.coe.info6205.sort.linearithmic.TimSort;
import edu.neu.coe.info6205.util.Config;
import edu.neu.coe.info6205.util.Timer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author 60444
 */
public class TimSortOutput {
    
    private static Config config;
    
    public static void main(String[] args) throws IOException{
        config = Config.load();
        String filePath = "./shuffledChinese-500k.txt";   
        HashMap<String,String> content = readTxt(filePath);  
        String[] xs = new String[content.size()];
        content.keySet().toArray(xs);
        TimSort<String> timsort = new TimSort<>(xs.length,config);
        timsort.sort(xs,0,xs.length);//sort by pinying
        
        List<String> list = new ArrayList<>();
        for(String s:xs){
            list.add(content.get(s));
            System.out.println(content.get(s)+" : "+s);
        }
        String path = "./SortedResultOfTimSort-500k.txt";
        writeFile(list,path);
        System.out.println(list.size()+" elements has saved into "+path);
        /*
        String path = "./SortedResultOfTimSort.txt";
        File file = new File(path);
        //create new file if not exist
        if(!file.isFile()){
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        List<String> values = new ArrayList<>(Arrays.asList(xs));
        String[] out = new String[values.size()];
        for(String s:content.keySet()){
            int i = values.indexOf(content.get(s));
            out[i] = s;
            values.set(i, "");
            System.out.println(i);
        }
        for(String s:out){
            System.out.println(s+" : "+content.get(s));
            writer.write(s+"\r\n");
        }
        */
        //find the Chinese names matched with pinying, print and save them.
    }
    /*
    public static void main(String[] args) throws IOException{
        config = Config.load();
        String filePath = "./shuffledChinese.txt";   
        HashMap<String,String> content = readTxt(filePath);  
        List<String> list = new ArrayList<>(content.keySet());
        Collections.sort(list, (a,b) -> content.get(a).compareTo(content.get(b)));
        System.out.println("Size : "+list.size());
        writeFile(list,"./SortedResult.txt");
    }
    */
}