package school.faang.BJS2_61638;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new LinkedList<>();

    public void startAutoUpload() {
        while (true) {
            synchronized (photosToUpload) {
                if (photosToUpload.isEmpty()) {
                    System.out.println("List of paths is empty!");
                    try {
                        photosToUpload.wait();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            System.out.println("Photo path added");
            photosToUpload.notify();
        }
    }

    public void uploadPhotos() {
        if (photosToUpload.isEmpty()) {
            System.out.println("List for uploading is empty");
            return;
        }
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
