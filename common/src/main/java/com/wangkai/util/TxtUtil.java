//package com.wangkai.util;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * txt读写工具类
// * Created by admin on 16/7/11.
// */
//public class TxtUtil {
//
//    // 写文件
//    public static  void writerTxt(List<String> list,String path) {
//        BufferedWriter fw = null;
//        try {
//            File file = new File(path);
//            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")); // 指定编码格式，以免读取时中文字符异常
//            for(String line : list){
//                fw.append(line.toString());
//                fw.newLine();
//            }
//            fw.flush(); // 全部写入缓存中的内容
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (fw != null) {
//                try {
//                    fw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    // 读文件
//    public static List<String> readTxt(String filePath) {
//        //
//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8")); // 指定读取文件的编码格式，要和写入的格式一致，以免出现中文乱码,
//            String str = null;
//            //
//            List<String> list = new ArrayList<>();
//            while ((str = reader.readLine()) != null) {
//                //
//                list.add(str);
//            }
//
//            return list;
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return null;
//    }
//}
