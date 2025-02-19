package bjs261625;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        List<String> newPhotos = List.of("C://Photos//1.jpg", "C://Photos//2.jpg");
        List<Thread> threads = new ArrayList<>();
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread newPhotoAddThread = new Thread(() -> newPhotos.forEach(uploader::onNewPhotoAdded));
        Thread autoUploadThread = new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                LOGGER.error("Thread {} started, but not completed due to InterruptedException",
                        Thread.currentThread().getName());
                throw new RuntimeException(e);
            }
        });
        threads.add(newPhotoAddThread);
        threads.add(autoUploadThread);
        threads.forEach(Thread::start);
        threads.get(0).join();
    }
}
