package faang.school.godbless.googlePhoto;

import java.util.List;

public class GooglePhoto {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        List<String> photos = List.of("photo1", "photo2", "photo3", "photo4", "photo5", "photo6",
                "photo7", "photo8", "photo9", "photo10", "photo11", "photo12",
                "photo13", "photo14", "photo15", "photo16");

        for (String photo : photos) {
            Thread producerThread = new Thread(() -> uploader.onNewPhotoAdded(photo));
            Thread consumerThread = new Thread(() -> {
                try {
                    uploader.startAutoUpload();
                } catch (InterruptedException e) {
                    System.out.println("Upload interrupted");
                }
            });

            producerThread.start();
            consumerThread.start();
        }
    }
}