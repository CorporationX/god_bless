package ru.kraiush.threads.BJS2_18347;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UploadingPhoto implements Runnable {

    private GooglePhotosAutoUploader loader;

    @Override
    public void run() {

        loader.startAutoUpload();
    }
}
