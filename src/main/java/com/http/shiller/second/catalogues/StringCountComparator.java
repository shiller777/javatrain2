package com.http.shiller.second.catalogues;

import java.util.Comparator;

public class StringCountComparator implements Comparator<FileInfoRecord> {

    public int compare(FileInfoRecord o1, FileInfoRecord o2) {
        return o1.compareTo(o2);

    }

}
