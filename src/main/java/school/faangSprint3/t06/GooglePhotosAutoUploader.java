package school.faangSprint3.t06;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private boolean isRunning = true;

    public synchronized void startAutoUpload() {
        while (isRunning) {
            try {
                while (photosToUpload.isEmpty() && isRunning) {
                    wait();
                }

                if (!isRunning) {
                    break;
                }
                uploadPhotos();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void onNewPhotoAdded(String photoPath) {
        photosToUpload.add(photoPath);
        System.out.println("Добавлена новая фотография: " + photoPath);
        notify();
    }

    private synchronized void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Загрузка фотографии: " + photo);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        photosToUpload.clear();
    }

    public synchronized void stop() {
        isRunning = false;
        notify();
    }
}