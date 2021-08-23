package com.stacey.files;

import java.io.File;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        String fileName = "d://1root/";
        printTree(fileName);
    }

    private void printTree(String fileName) {
        File root = new File(fileName);
        printChildren(root, 0);
    }

    private void printChildren(File root, int level) {
        String tab = "\t";
        //String tabs = tab.repeat(level);
        String tabs = String.join("", Collections.nCopies(level, tab));

        File[] children = root.listFiles();
        if ( children!=null && children.length>0 ) {
            for (File file: children) {
                System.out.println(tabs + file.getName());
                if ( file.isDirectory() ) {
                    printChildren(file, level+1);
                }
            }
        } else {
            System.out.println(tabs + "(empty)");
        }
    }
}
