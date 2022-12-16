package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("First File.txt");
        File second = new File("Second File.txt");
        File resulting = new File("Resulting File.txt");
         System.out.println(FileFunction.write(file, second, resulting));
    }
}
