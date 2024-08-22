package faang.school.godbless.googlePhoto;

import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
public class GooglePhotosAutoUploader {
    private final Object lock;
    private List<String> photosToUpload;

    public void startAutoUpload() {
        try {
            synchronized (lock) {
                while (!Thread.currentThread().isInterrupted()) {
                    if (photosToUpload.isEmpty()) {
                        lock.wait();
                    }
                    uploadPhotos();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("work stopped");
        }
    }

    private void uploadPhotos() {
        Iterator<String> iterator = photosToUpload.iterator();
        do {
            System.out.println(iterator.next() + " uploaded");
            iterator.remove();
        } while (iterator.hasNext());//такой странный цикл для того, чтобы избежать ConcurrentModificationException,
        //который выбрасывается в цикле for each из за того, что коллекцию меняет кто то, кроме итератора
    }

    public void onNewPhotoAdded(String path) {
        synchronized (lock) {
            photosToUpload.add(path);
            if (photosToUpload.size() == 1) {
                lock.notify();
            }
        }
    }
}
