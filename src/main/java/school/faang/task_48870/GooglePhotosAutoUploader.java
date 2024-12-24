package school.faang.task_48870;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>(List.of("/C/direction/user/Ayaz/music",
            "/C/users/user/private/contract",
            "/D/users/Liam/photos",
            "/D/cc/dd/ff"));

    public void startAutoUpload() {
        long timeout = 2000;
        long startTime = System.currentTimeMillis();
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait(timeout);
                        long elapsedTime = System.currentTimeMillis() - startTime;
                        if (elapsedTime >= timeout) {
                            break;
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("sfsdfs" + e.getMessage());
                    }
                } else {
                    System.out.println("Добавляем новые файлы");
                    uploadPhotos();
                }

            }
        }
    }

    public void uploadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println("Загружаем фотографию: " + photo);
        }
        photosToUpload.clear();
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Уведомляем лок...");
            lock.notifyAll();
        }
    }
}
