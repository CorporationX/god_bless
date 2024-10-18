package school.faang.googlephotosyng;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> photos = new ArrayList<>();
        photos.add("photo1");
        photos.add("photo2");
        photos.add("photo3");
        photos.add("photo4");
        photos.add("photo5");
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader(photos);

        Thread uploadPhotos = new Thread(uploader::startAutoUpload);
        Thread addPhotos = new Thread(() -> uploader.onNewPhotoAdded(
                "New_photo1"));

        uploadPhotos.start();
        addPhotos.start();

        try {
            uploadPhotos.join();
            addPhotos.join();
        } catch (InterruptedException e) {
            System.out.println("Execution has been interrupted");
            e.printStackTrace();
            throw new IllegalStateException(e);
        }

        if (!uploadPhotos.isAlive() && !addPhotos.isAlive()) {
            System.out.println("Both threads have finished execution.");
            System.out.println("Photos in uploader:" + uploader.getPhotosToUpload());
        }
    }
}
