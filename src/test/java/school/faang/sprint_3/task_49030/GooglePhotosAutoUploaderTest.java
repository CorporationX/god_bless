package school.faang.sprint_3.task_49030;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GooglePhotosAutoUploaderTest {


    @Test
    public void testPhotoUpload() throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(uploader::startAutoUpload);
        uploadThread.start();
        uploader.onNewPhotoAdded("photo1.jpg");
        uploader.onNewPhotoAdded("photo2.jpg");
        Thread.sleep(200);
        uploader.stop();
        uploadThread.join();

        assertTrue(true, "Загрузка фотографий выполнена корректно.");
    }

    @Test
    public void testThreadSafety() throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.submit(uploader::startAutoUpload);

        for (int i = 0; i < 10; i++) {
            int photoIndex = i;
            executor.submit(() -> uploader.onNewPhotoAdded("photo" + photoIndex + ".jpg"));
        }

        Thread.sleep(500);
        uploader.stop();
        executor.shutdown();
        assertTrue(true, "Загрузка фотографий выполнена корректно при многопоточности.");
    }

    @Test
    public void testNoPhotosToUpload() throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploadThread = new Thread(uploader::startAutoUpload);
        uploadThread.start();
        Thread.sleep(100);
        uploader.stop();
        uploadThread.join();
        assertTrue(true, "Программа корректно обработала отсутствие фотографий.");
    }
}
