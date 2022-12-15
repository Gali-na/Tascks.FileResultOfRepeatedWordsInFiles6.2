package org.example;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers1=new ArrayList<Integer>();
        integers1.add(1);
        integers1.add(2);
        integers1.add(4);
        integers1.add(6);
        ArrayList<Integer> integers2=new ArrayList<Integer>();
        integers2.add(1);
        integers2.add(3);
        integers2.add(5);
       integers1.retainAll(integers2);
       // System.out.println(integers1);
        //System.out.println(integers2);
        Set<Integer> set =new TreeSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(4);

        Set<Integer> set2 =new TreeSet<>();
        set2.add(1);
        set2.add(1);
        set2.add(3);
        set2.add(5);

        set.retainAll(set2);
        System.out.println(set);
    }
}
