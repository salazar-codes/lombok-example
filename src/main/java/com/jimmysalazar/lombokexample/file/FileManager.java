package com.jimmysalazar.lombokexample.file;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;

public class FileManager {

    public static void createFiles(String ...files){
        for ( String file : files){
            createFile(file);
        }
    }

    @SneakyThrows // Evitar tener que propagar la excepción a todas las clases
    // Tener cuidado ya que usarla puede causar que nos impida usar el try-catch
    // se hace para evitar usar el throw
    public static void createFile(String file){
        File f = new File(file);
        f.createNewFile();
    }
}
