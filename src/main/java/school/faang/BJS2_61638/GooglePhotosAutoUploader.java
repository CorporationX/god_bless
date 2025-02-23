package school.faang.BJS2_61638;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GooglePhotosAutoUploader {
    public final Object lock = new Object();
    private final List<String> photosToUpload = new LinkedList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    System.out.println("List of paths is empty!");
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println("Photo path added");
            lock.notify();
        }
    }

    public void uploadPhotos() {
        Iterator<String> iterator = photosToUpload.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            iterator.remove();
            System.out.println("Path \"%s\" uploaded!".formatted(s));
        }
    }

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
