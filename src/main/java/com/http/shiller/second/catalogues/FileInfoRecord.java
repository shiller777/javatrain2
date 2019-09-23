package com.http.shiller.second.catalogues;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

public class FileInfoRecord implements Comparable<FileInfoRecord> {
    @Getter
    @Setter
    String fileName;
    @Getter
    @Setter
    long stringsCount;
    @Getter
    @Setter
    long symbolsCount;

    FileInfoRecord(String fileName, long stringsCount, long symbolsCount) {
        this.fileName = fileName;
        this.stringsCount = stringsCount;
        this.symbolsCount = symbolsCount;
    }

    public String toString() {
        return String.format("FileInfoRecord: {fileName: %s; stringsCount: %s; symbolsCount: %s}",
                getFileName(), getStringsCount(), getSymbolsCount());
    }

    @Override
    public int compareTo(FileInfoRecord o) {
        if (this.stringsCount > o.stringsCount) {
            return 1;
        } else {
            if (this.stringsCount == o.stringsCount) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
