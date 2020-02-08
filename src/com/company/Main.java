package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner mk = new Scanner(System.in);
        System.out.println("Enter your string : ");
        String test = mk.next();
        long start = System.currentTimeMillis();
        String total_String = "";
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        File file = new File("C:\\Users\\Nahid MK\\Desktop\\subject\\hello.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null){
                total_String+= st;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String arr[] = total_String.split(" ");
        HashSet<String>set = new HashSet<>(Arrays.asList(total_String.split(" ")));
        for(String i : set)
        {
            if(i.charAt(0)==test.charAt(0))
            {
                list1.add(i);
            }
        }

        for(int i = 0;i<test.length();i++) {
            if(i%2==0)
            {
                int count = 0;
                for(int k = 0;k<list1.size();k++){
                    if (count<=list1.size()-1 && test.charAt(i) == list1.get(count).charAt(i) && test.length() <= list1.get(count).length()) {

                        list2.add(list1.get(count));

                    }
                    count++;
                }
                list1.clear();
            }else {

                int count1 = 0;
                for(int k = 0;k<list2.size();k++) {
                    if (count1<=list2.size()-1 && test.charAt(i) == list2.get(count1).charAt(i)) {

                        list1.add(list2.get(count1));
                    }
                    count1++;
                }
                System.out.println("second if "+ list1);
                list2.clear();
            }
        }
        System.out.println("Most Suggest word from "+arr.length+" word");
        try {
            if (list1.isEmpty()) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(list2.get(i));
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    System.out.println(list1.get(i));
                }
            }
        }catch (Exception e)
        {

        }
        long end = System.currentTimeMillis();
        System.out.println("The time have taken = "+(end-start));
//        list2.forEach(System.out::println);
//        list1.forEach(System.out::println);
    }
}
