package com.http.shiller.second.catalogues;

import java.util.Comparator;

public class NameComparator implements Comparator<FileInfoRecord> {

    public int compare(FileInfoRecord o1, FileInfoRecord o2) {
        int less = o1.getFileName().length() < o2.getFileName().length() ?
                o1.getFileName().length() : o2.getFileName().length();
        int lalala = o1.getFileName().length() - o2.getFileName().length();

        for (int i = 0; i < less; i++) {
            byte ololol = (byte) (o1.getFileName().charAt(i) - o2.getFileName().charAt(i));
            if (ololol != 0) {
                return ololol;
            }
        }
        return lalala;
    }
}
