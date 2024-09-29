package ru.kraiush.threads.BJS2_18347;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ViewingPhotos implements Runnable {

    private GooglePhotosAutoUploader loader;

    @Override
    public void run() {
        List<GooglePhoto> list = loader.seePhotos();
//        list.forEach(System.out::println);
    }
}
