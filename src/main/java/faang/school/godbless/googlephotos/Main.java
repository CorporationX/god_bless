package faang.school.godbless.googlephotos;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        List<String> photos = new ArrayList<>() {{
            add("photo11.jpg");
            add("photo12.jpg");
            add("photo13.jpg");
            add("photo14jpg");
            add("photo15.jpg");
            add("photo16.jpg");
            add("photo17.jpg");
            add("photo18.jpg");
            add("photo19.jpg");
            add("photo20.jpg");
        }};

        Thread startAutoUpload = new Thread(() -> googlePhotosAutoUploader.startAutoUpload());
        Thread addPhotoThread = new Thread(() -> {
            photos.forEach((photo -> {
                googlePhotosAutoUploader.onNewPhotoAdded(photo);
            }));
        });

        addPhotoThread.start();
        startAutoUpload.start();

//        ExecutorService executors = Executors.newFixedThreadPool(2);
//        executors.submit(() -> {
//            photos.forEach((photo ->
//                    googlePhotosAutoUploader.onNewPhotoAdded(photo)));
//        });
//
//        executors.submit(() -> googlePhotosAutoUploader.onNewPhotoAdded("Photo x.jpg"));
//        executors.submit(() -> googlePhotosAutoUploader.startAutoUpload());
//        executors.shutdown();
//        executors.awaitTermination(10, TimeUnit.SECONDS);
    }
}
