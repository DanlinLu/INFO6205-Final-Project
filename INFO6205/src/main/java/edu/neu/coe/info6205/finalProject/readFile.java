/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.finalProject;

import static edu.neu.coe.info6205.finalProject.convertToPinyin.getAllPinyin;
import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author 60444
 */
public class readFile {
    public static void main(String[] args) throws Exception {  
        String filePath = "./shuffledChinese4.txt";
//      String filePath = "D:/article333.txt";    
//      String filePath = "D:/article111.txt";    
        HashMap<String,String> content = readTxt(filePath);  
        System.out.println(content);  
    }  
      
      
    /** 
     * 解析普通文本文件  流式文件 如txt 
     * @param path 
     * @return 
     */  
    @SuppressWarnings("unused")  
    //used for whose code is "UTF-8"
    public static HashMap<String,String> readTxt(String path){  
        HashMap<String,String> map = new HashMap<>();
        //StringBuilder content = new StringBuilder("");  
        try {  
            //String code = resolveCode(path);  
            File file = new File(path);  
            InputStream is = new FileInputStream(file);  
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");  //could change code here
            BufferedReader br = new BufferedReader(isr);  
//          char[] buf = new char[1024];  
//          int i = br.read(buf);  
//          String s= new String(buf);  
//          System.out.println(s);  
            String str = "";  
            convertToPinyin toPinYin = new convertToPinyin();
            while (null != (str = br.readLine())) {  
                //content.append(str);  
                map.put(toPinYin.getAllPinyin(str), str);
            }  
            br.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
            System.err.println("读取文件:" + path + "失败!");  
        }  
        return map;
    }  
}
