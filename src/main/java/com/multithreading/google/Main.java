package com.multithreading.google;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googleLoader = new GooglePhotosAutoUploader();

        List<String> pathToPhotos = Arrays.asList("путь к фотографии: C:\\...",
                "путь к фотографии: D:\\...",
                "путь к фотографии: F:\\...");

        Thread loadPhoto = new Thread(googleLoader::startAutoUpload);
        Thread observer = new Thread(() -> {
            for (String path : pathToPhotos) {
                googleLoader.onNewPhotoAdded(path);
            }
        });

        loadPhoto.start();
        observer.start();

        try {
            observer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loadPhoto.interrupt();
    }
}
