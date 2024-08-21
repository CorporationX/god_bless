package com.multithreading.google;

import lombok.Getter;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GooglePhotosAutoUploader {

    private static final Object LOCK = new Object();
    private final static List<String> PHOTOS_TO_UPLOAD = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (LOCK) {
            while (true) {
                if (PHOTOS_TO_UPLOAD.isEmpty()) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Ожидание прервано");
                        return;
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void uploadPhotos() {
        System.out.println("Фотография загружена");
        PHOTOS_TO_UPLOAD.remove(0);
    }

    public void onNewPhotoAdded(String photoPath) {
        if (photoPath.isEmpty() && photoPath.isBlank() && photoPath == null) {
            throw new IllegalArgumentException("Not valid");
        }
        synchronized (LOCK) {
            PHOTOS_TO_UPLOAD.add(photoPath);
            System.out.println("Фотография добавлена.Путь: " + photoPath);
            LOCK.notify();
        }
    }
}