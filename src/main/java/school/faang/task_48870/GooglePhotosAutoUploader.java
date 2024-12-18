package school.faang.task_48870;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>(List.of("/C/direction/user/Ayaz/music", "/C/users/user/private/contract",
            "/D/users/Liam/photos", "/D/cc/dd/ff"));

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("dfgdfg" + e.getMessage());
                }
            }
            System.out.println("Добавляем новые файлы");
            uploadPhotos();
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
            lock.notify();
        }
    }
}
