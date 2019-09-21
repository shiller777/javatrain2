package com.http.shiller.second.catalogues;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String FOLDER_PATH = "D:\\Projects\\javatrain2\\src\\main\\java\\com\\http\\shiller\\second\\catalogues";

        File myFile = new File(FOLDER_PATH);
        Arrays.stream(myFile.listFiles()).filter(o -> o.getName().endsWith(".java"))
                .filter(o -> !o.isDirectory()).forEach(o -> {
            try {
                System.out.println(String.format("File: %s - Strings: %d", o.getName(),
                        Files.lines(o.toPath()).filter(o1 -> !o1.contains("package"))
                        .filter(o1 -> !o1.contains("import")).filter(o1 -> !o1.isEmpty()).count()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
