package com.http.shiller.second.catalogues;

import java.io.File;
import java.util.List;

public class FileRunner {
    public static void initAllFiles(File lookIn, List<File> files) {
        File[] inside = lookIn.listFiles();
        if (inside != null) {
            for (File file : inside) {
                if (file.isDirectory()) {
                    initAllFiles(file, files);
                    continue;
                }
                files.add(file);
            }
        }
    }
}
