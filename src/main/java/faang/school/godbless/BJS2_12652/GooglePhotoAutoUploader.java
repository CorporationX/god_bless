package faang.school.godbless.BJS2_12652;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotoAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public static void main(String[] args) {
        GooglePhotoAutoUploader googlePhotoAutoUploader = new GooglePhotoAutoUploader();
        googlePhotoAutoUploader.photosToUpload.add("основное фото профиля");
        googlePhotoAutoUploader.photosToUpload.add("превью основного альбома");
        googlePhotoAutoUploader.photosToUpload.add("превью второго альбома");
        googlePhotoAutoUploader.photosToUpload.add("превью третьего альбома");

        Thread uploadThread = new Thread(() -> {
            try {
                googlePhotoAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                googlePhotoAutoUploader.uploadPhotos();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        uploadThread.start();

        Thread viewThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2000);
                    googlePhotoAutoUploader.onNewPhotoAdded("новое фото " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        viewThread.start();
    }

    public void startAutoUpload() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                if (photosToUpload.isEmpty()) {
                    lock.wait();
                } else uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photo) {
        synchronized (lock) {
            photosToUpload.add(photo);
            System.out.println("Добавлено новое фото " + photo);
            lock.notify();
        }
    }

    public void uploadPhotos() throws InterruptedException {
        synchronized (lock) {
            for (String photo : photosToUpload) {
                System.out.println("Выполняется загрузка фото " + photo);
            }
            photosToUpload.clear();
            lock.notify();
        }
    }
}
