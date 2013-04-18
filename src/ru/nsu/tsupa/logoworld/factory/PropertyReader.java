package ru.nsu.tsupa.logoworld.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

public class PropertyReader {
    private static final String FileName = "config.txt";
    private static final String DirSeparator = System.getProperty("file.separator");
    private static final Properties props = new Properties();

    public static TreeMap<String, String> getProperties() {
        File currentDir = new File( "." );

        try {
            String FilePath = currentDir.getCanonicalPath() + DirSeparator + FileName;
            System.out.println(FilePath);
            FileInputStream fin = new FileInputStream(FilePath);

            props.load(fin);

            Set<String> tempSet = props.stringPropertyNames();
            TreeMap<String, String> tempMap = new TreeMap<String, String>();

            for (String key : tempSet) {
                tempMap.put(key, props.getProperty(key));
            }

            return tempMap;

        } catch ( FileNotFoundException e ) {
            System.out.println("File \"" + FileName + "\" not found.");
        } catch ( IOException e ) {
            System.out.println("IO Error.");
        }
        return null;
    }
}
