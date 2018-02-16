package com.despairs.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author EKovtunenko
 */
public class FileWriter {

    public static void write(Object object, String path) throws FileNotFoundException {
        try (PrintStream stream = new PrintStream(new File(path))) {
            stream.print(object);
        }
    }
}
