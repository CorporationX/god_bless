package school.faang.bjs248934;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = Collections.synchronizedList(new ArrayList<>());

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("Waiting for files to upload...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted, failed to complete operation");
                        Thread.currentThread().interrupt();
                    }
                }

                System.out.println("Uploading new files...");
                uploadPhotos();
            }
        }
    }

    private void uploadPhotos() {
        synchronized (photosToUpload) {
            Iterator<String> iterator = photosToUpload.iterator();
            while (iterator.hasNext()) {
                String photo = iterator.next();
                System.out.println(photo + " is being uploaded to servers...");
                iterator.remove();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("New file added to upload list: " + photoPath);
            lock.notify();
        }
    }

    public void addNewPhotos(List<String> filenames) {
        splitArrayToFibonacciChunksAndProcess(filenames);
    }

    private void splitArrayToFibonacciChunksAndProcess(List<String> filenames) {
        int a = 0;
        int b = 1;
        while (a <= filenames.size()) {
            filenames.stream().skip(a).limit(b - a).forEach(this::onNewPhotoAdded);
            int next = a + b;
            a = b;
            b = next;
        }
    }
}
