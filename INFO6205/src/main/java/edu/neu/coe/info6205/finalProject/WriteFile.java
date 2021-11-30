/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.finalProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 *
 * @author 60444
 */
public class WriteFile {
    public static void writeFile(List<String> list,String path) throws IOException{
        FileOutputStream writerStream = new FileOutputStream(path);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(writerStream, "UTF-8")); 
        for(String l:list){
            writer.write(l+"\r\n");
        }
        writer.close();  
        /*
        File file = new File(path);
        //create new file if not exist
        if(!file.isFile()){
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for(String l:list){
            writer.write(l+"\r\n");
        }
*/
    }
}
