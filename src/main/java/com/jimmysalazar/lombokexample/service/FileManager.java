package com.jimmysalazar.lombokexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;

public class FileManager{
//public class FileManager implements Closeable{

    public static final Logger Log = LoggerFactory.getLogger(FileManager.class);

    public void write(String text, String file) {
        Log.info("Writing {} in {}", text,file);
    }

    // método para liberar recursos
    public void releaseResources() throws IOException {
        Log.info("Liberando recursos");
    }

    /*
    @Override
    public void close() throws IOException {
        Log.info("Liberando recursos");
    }
    */

}
