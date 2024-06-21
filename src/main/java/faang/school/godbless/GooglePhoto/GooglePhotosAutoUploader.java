package faang.school.godbless.GooglePhoto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GooglePhotosAutoUploader{
    Object lock = new Object();
    static List<String> photosToUpload = new ArrayList<>(List.of(
            "/path/to/photo1.jpg",
            "/path/to/photo2.jpg",
            "/path/to/photo3.jpg"
    ));

    public void startAutoUpload() throws InterruptedException {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                lock.wait();
            }
            uploadPhotos();
            photosToUpload.clear();
        }
    }

    private static void uploadPhotos() {
        System.out.println("Uploading photo");
        for (String photo : photosToUpload) {
            System.out.println(photo);
        }
    }

    public void onNewPhotoAdded(String photoPath){
        synchronized (lock){
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }
}
