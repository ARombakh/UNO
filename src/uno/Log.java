/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static uno.UNO.logFilePath;
import static uno.UNO.logFileName;

/**
 *
 * @author artyom
 */
public class Log {
    public boolean pathExists(Path path) {
        return (Files.exists(path));
    }
    
    public boolean fileExists(File file) {
        return (file.exists());
    }
    
    public boolean createFile(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("New file created");
            } else {
                System.out.println("File already exists");
            }
            return true;
        } catch (IOException e) {
            System.out.println("The file cannot be created!" + e.getMessage());
            return false;
        }
    }
        
    public static void main(String[] args) throws Exception {
        Log log = new Log();
        
        System.out.println(logFilePath);
        Path path = Paths.get(logFilePath);
        
        if(!log.pathExists(path)) {
            throw new Exception("The path " + logFilePath + " does not exist");
        }

        File fileName = new File(logFilePath + File.separator + logFileName);
        
        if (!log.createFile(fileName)) {
            System.out.println("File wasn't created");
        }
        
        FileOutputStream fos = new FileOutputStream(fileName);
        
        PrintWriter pw = new PrintWriter(fos);

        pw.println("something");
        pw.close();
    }
}