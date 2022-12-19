package fr.azrotho.taverne.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
    public static void createFile(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static void save(File file, String text) {
        try {
            createFile(file);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String loadContent(File file) {
        try {
            if(!file.exists()) {
                createFile(file);
            }
            final BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
            final StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            reader.close();
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
