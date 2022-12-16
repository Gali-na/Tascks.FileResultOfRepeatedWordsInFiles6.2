package org.example;

import java.io.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileFunction {
    public static List<String> read(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> listOfWords = new ArrayList<>();
        if (FileFunction.checkFile(file)) {
            try (Reader reader = new BufferedReader(new FileReader(file))) {
                char[] arryChar = new char[1024];
                while ((reader.read(arryChar)) > 0) {
                    stringBuilder.append(arryChar);
                }
            } catch (IOException e) {
                e.getMessage();
            }
            Pattern pattern = Pattern.compile("A-Za-z");
            Matcher matcher = null;
            String[] arryWords = stringBuilder.toString().split("[^A-Za-z]");
            for (String str : arryWords) {
                if (Pattern.matches("[A-Za-z]+", str)) {
                    listOfWords.add(str);
                }
            }
        }
        return listOfWords;
    }

    public static String searchTheSameWords(File fileOne, File fileTwo) {
        StringBuilder rezult = new StringBuilder();
        List<String> wordsFromFileOne = read(fileOne);
        List<String> wordsFromFileTwo = read(fileTwo);
        wordsFromFileOne.retainAll(wordsFromFileTwo);
        TreeSet<String> rezultSet = new TreeSet<>();
        for (String str : wordsFromFileOne) {
            rezultSet.add(str);
        }
        for (String strSet : rezultSet) {
            rezult.append(strSet);
            rezult.append(" ");
        }
        return rezult.toString();
    }

    public static boolean write(File fileOne, File fileTwo, File fileRezult) {
        String information = searchTheSameWords(fileOne, fileTwo);
        if (FileFunction.checkFile(fileRezult)) {
            try (Writer writer = new BufferedWriter(new FileWriter(fileRezult))) {
                writer.write(information);
            } catch (IOException e) {
                e.getMessage();
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    public static boolean checkFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.isFile() == false) {
            return false;
        }
        return true;
    }
}
