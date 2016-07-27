package com.wangkai.util;

import com.wangkai.bean.OrderBean;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by admin on 16/7/18.
 */
public class CsvUtil {

    public static List<String> read(String filename){
        //
        List<String> list = new ArrayList<>();
        InputStreamReader isr = null;
        BufferedReader bufferedreader = null;
        try {
            isr = new InputStreamReader(new FileInputStream(new File(filename)), "GBK");
            bufferedreader = new BufferedReader(isr);
            String stemp;
            while ((stemp = bufferedreader.readLine()) != null) {
                list.add(stemp);
            }
        } catch (Exception e) {
           //
            System.out.print("读取失败!");
        }finally {
            try {
                isr.close();
                bufferedreader.close();
            } catch (IOException e) {
                //
            }
        }
        //
        return list;
    }

    public static List<OrderBean> readList(String filename){
        //
        List<String> list = read(filename);
        //
        List<OrderBean> retrunList = new ArrayList<>();
        list.forEach(colum -> {
            //
            OrderBean order = new OrderBean();
            String [] str = colum.split(",");
            //
            if(!str[0].equals("orderid")){
                if(str.length == 3){
                    order.setOrderId(Integer.parseInt(str[0]));
                    order.setCustId(Integer.parseInt(str[1]));
                    order.setApplyDate(str[2]);
                    retrunList.add(order);
                }
            }

        });
        //
        return retrunList;
    }

    public static void createCsv(List<String> list,String path) throws IOException {
        File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
        } else{
            file.delete();
        }
        //
        StringBuilder sb = new StringBuilder("");
        FileOutputStream writerStream = new FileOutputStream(file, true);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(writerStream,"GBK"));
        for (Iterator itt = list.iterator(); itt.hasNext();) {
            String fileStr = itt.next().toString();
            sb.append(fileStr + "\r\n");
        }
        output.write(sb.toString());
        output.flush();
        output.close();
    }

    //public static void main(String args[]){
        //
        //List<OrderBean> list = readList("/Users/admin/Desktop/order.csv");
        //
        //System.out.println(list.size());
//        List<String> list = read("/Users/admin/Desktop/order.csv");
//        try {
//            createCsv(list,"/Users/admin/Desktop/his-orders.csv");
//        } catch (IOException e) {
//            //
//        }

    //}
}
