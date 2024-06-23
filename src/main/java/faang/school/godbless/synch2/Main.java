package faang.school.godbless.synch2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        List<GooglePhoto> photos = getPhotos();

        Thread photoAddThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        photoAddThread.start();
        photos.forEach(googlePhoto -> startingThreads(googlePhoto, googlePhotosAutoUploader, threads));

        threads.forEach(Main::threadJoin);

        googlePhotosAutoUploader.endAutoLoad();
    }

    private static void startingThreads(GooglePhoto googlePhoto, GooglePhotosAutoUploader googlePhotosAutoUploader, List<Thread> threads) {
        Thread thread = new Thread(() -> googlePhotosAutoUploader.
                onNewPhotoAdded(googlePhoto.photoPath()));
        thread.start();
        threads.add(thread);
    }

    private static void threadJoin(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<GooglePhoto> getPhotos() {
        return List.of(new GooglePhoto("photo1.jpg"), new GooglePhoto("photo2.jpg"),
                new GooglePhoto("photo3.jpg"), new GooglePhoto("photo4.jpg"));
    }
}
