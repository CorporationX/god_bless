package faang.school.godbless.kxnvg.googlephoto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GooglePhotosAutoUploader {

    private Lock lock;
    @Getter
    @Setter
    private List<String> photosToUpload;

    public GooglePhotosAutoUploader() {
        lock = new ReentrantLock();
        photosToUpload = new ArrayList<>();
    }

    public void startAutoUpload() {
        synchronized (lock) {
            while (true) {
                if (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                        System.out.println("Нет фотографий готовых к загрузке!");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    uploadPhotos();
                }
            }
        }
    }

    private void uploadPhotos() {
        Iterator<String> iterator = photosToUpload.iterator();

        while (iterator.hasNext()) {
            System.out.println("Фото " + iterator.next() + " выгружено в Google Photo");
            iterator.remove();
        }
        System.out.println("===   Все фотографии загружены в Google Photo   ===");
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
