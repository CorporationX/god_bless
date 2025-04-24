package school.faang.photos;

import school.WaitUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int THREAD_POOL_SIZE = 2;
    private static final int THREAD_POOL_TIMEOUT_SECONDS = 10;
    private static final int PHOTO_UPLOAD_DELAY_MILLIS = 1000;


    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();

        Runnable photosIncome =
                () -> {
                    autoUploader.onNewPhotoAdded(
                            "photo11.jpg",
                            "photo12.jpg",
                            "photo13.jpg",
                            "photo14.jpg",
                            "photo15.jpg",
                            "photo16.jpg",
                            "photo17.jpg");
                    WaitUtils.sleep(PHOTO_UPLOAD_DELAY_MILLIS);
                    autoUploader.onNewPhotoAdded(
                            "photo21.jpg",
                            "photo22.jpg",
                            "photo23.jpg"
                    );
                    WaitUtils.sleep(PHOTO_UPLOAD_DELAY_MILLIS * 2);
                    autoUploader.onNewPhotoAdded(
                            "photo31.jpg",
                            "photo32.jpg",
                            "photo33.jpg",
                            "photo34.jpg",
                            "photo35.jpg",
                            "photo36.jpg",
                            "photo37.jpg"
                    );
                    autoUploader.turnOffAutoUpdate();
                };


        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        executorService.submit(autoUploader::startAutoUpload);
        executorService.submit(photosIncome);

        WaitUtils.shutdownExecutorWithWait(executorService, THREAD_POOL_TIMEOUT_SECONDS, TimeUnit.SECONDS);
    }
}
