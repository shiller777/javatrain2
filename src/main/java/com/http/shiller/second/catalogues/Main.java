package com.http.shiller.second.catalogues;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String FOLDER_PATH = "D:\\Projects\\javatrain2";

        File myFile = new File(FOLDER_PATH);
        Arrays.stream(myFile.listFiles()).filter(o -> o.getName().endsWith(".java")).filter(o -> !o.isDirectory()).forEach(o -> System.out.println(o.getName()));

    }
}
