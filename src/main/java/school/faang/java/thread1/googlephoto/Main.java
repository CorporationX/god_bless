package school.faang.java.thread1.googlephoto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        ExecutorService executorService= Executors.newFixedThreadPool(2);

        Runnable runnableRead = googlePhotosAutoUploader::startAutoUpload;
        Runnable runnableWrite = googlePhotosAutoUploader::onNewPhotoAdded;

        executorService.execute(runnableRead);
        executorService.execute(runnableWrite);

        executorService.shutdown();
    }
}
