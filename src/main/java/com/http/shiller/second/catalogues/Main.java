package com.http.shiller.second.catalogues;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static long linesCounter = 0;
    private static long symbolsCounter = 0;

    public static void main(String[] args) {
        String FOLDER_PATH = "D:\\Projects\\javatrain2\\src\\main\\java\\com\\http\\shiller\\second\\catalogues";

        List<File> files = new ArrayList<>();
        FileRunner.initAllFiles(new File(FOLDER_PATH), files);

        List<FileInfoRecord> fileInfoList = new ArrayList<>();

        files.stream()
                .filter(o -> o.getName().endsWith(".java"))
                .filter(o -> !o.isDirectory())
                .forEach(o -> {
                    try {
                        linesCounter = Files.lines(o.toPath())
                                .filter(o1 -> !o1.contains("package")
                                        && !o1.contains("import")
                                        && !o1.isEmpty())
                                .count();

                        Files.lines(o.toPath())
                                .filter(o2 -> !o2.contains("package")
                                        && !o2.contains("import")
                                        && !o2.isEmpty())
                                .forEach(o2 -> symbolsCounter += o2.length());

                        fileInfoList.add(new FileInfoRecord(o.getName(), linesCounter, symbolsCounter));
                        linesCounter = 0;
                        symbolsCounter = 0;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        fileInfoList.stream()
                .sorted(new StringCountComparator().thenComparing(new NameComparator()))
                .forEach(System.out::println);


        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("===========================");

        //to delete (check of second comparator separately from first)
        fileInfoList.sort(new NameComparator());
        fileInfoList.forEach(System.out::println);

    }
}
