package com.http.shiller.second.catalogues;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String FOLDER_PATH = "D:\\Projects\\javatrain2\\src\\main\\java\\com\\http\\shiller\\second\\catalogues";

        File myFile = new File(FOLDER_PATH);

        List<FileInfoRecord> fileInfoList = new ArrayList<>();
        final long[] linesCounter = {0};
        final long[] symbolsCounter = {0};
        symbolsCounter[0] = 0;

        Arrays.stream(myFile.listFiles()).filter(o -> o.getName().endsWith(".java"))
                .filter(o -> !o.isDirectory()).forEach(o -> {
            try {

                linesCounter[0] = Files.lines(o.toPath()).filter(o1 -> !o1.contains("package"))
                        .filter(o1 -> !o1.contains("import")).filter(o1 -> !o1.isEmpty()).count();


                Files.lines(o.toPath()).filter(o2 -> !o2.contains("package"))
                        .filter(o2 -> !o2.contains("import")).filter(o2 -> !o2.isEmpty())
                        .forEach(o2 -> symbolsCounter[0] += o2.length());

                fileInfoList.add(new FileInfoRecord(o.getName(), linesCounter[0], symbolsCounter[0]));



//                System.out.println(String.format("File: %s - Strings: %d", o.getName(),
//                        Files.lines(o.toPath()).filter(o1 -> !o1.contains("package"))
//                                .filter(o1 -> !o1.contains("import")).filter(o1 -> !o1.isEmpty()).count()));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        //fileInfoList.stream().forEach(q -> System.out.println(q.toString()));

        fileInfoList.sort(new StringCountComparator().thenComparing(new NameComparator()));
        fileInfoList.forEach(System.out::println);



        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("===========================");

        //to delete (check of second comparator separately from first)
        fileInfoList.sort(new NameComparator());
        fileInfoList.forEach(System.out::println);

    }
}
