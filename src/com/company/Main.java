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
        List<String> list2 = new ArrayList<>();
        String st = "";
        File file = new File("C:\\Users\\Nahid MK\\IdeaProjects\\hello\\file.txt");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            while ((st = br.readLine()) != null) {
                stringBuilder.append(st).append(" ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        total_String = stringBuilder.toString();
        TreeSet<String> set = new TreeSet<>(Arrays.asList(total_String.split(" ")));
        int total_wrod = (new ArrayList<>(Arrays.asList(total_String.split(" "))).size());
        List<String> list1 = new ArrayList<>(set);
        list1.remove(0);
        for (int i = 0; i < test.length(); i++) {

            if (i % 2 == 0) {
                for (int k = 0; k < list1.size(); k++) {

                    if (test.charAt(i) == list1.get(k).charAt(i) && test.length() <= list1.get(k).length()) {

                        list2.add(list1.get(k));

                    }
                }
                list1.clear();
            } else {

                for (int k = 0; k < list2.size(); k++) {
                    if (test.charAt(i) == list2.get(k).charAt(i)) {

                        list1.add(list2.get(k));
                    }
                }
                list2.clear();
            }
        }
        System.out.println("Most Suggest word from " + total_wrod + " word");
        if (list1.isEmpty() && list2.isEmpty()) {
            System.out.println("Sorry no match found...!");
        }
        else {
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
            } catch (Exception e) {

            }

        }
        long end = System.currentTimeMillis();
        System.out.println("The time have taken = " + (end - start) + " milli second");
    }
}
