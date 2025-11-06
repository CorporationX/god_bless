package school.faang.googlePhotoSync;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>(List.of("first", "second", "third"));

    public void startAutoUpload()  {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Поток " + Thread.currentThread().getName() + " остановлен");
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notifyAll();
        }
    }

    private void uploadPhotos() {
        Iterator<String> iterator = photosToUpload.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
    }
}
