package faang.school.godbless.threads.google;

import java.util.ArrayList;
import java.util.List;

public class GooglePhoto {
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload(){
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (photosToUpload) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("Ожидаю список фото для отправки на сервер... ");
                    try {
                        photosToUpload.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Was interrupted");
                    }
                }
                uploadPhotos();
            }
        }

    }

    private void uploadPhotos() {
        synchronized (photosToUpload) {
            for (String photo : photosToUpload) {
                System.out.println("Фотография " + photo + " отправлена на сервер");
            }
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            System.out.println("Фотография " + photoPath + " добавлена в список");
            photosToUpload.notify();
        }
    }
}
