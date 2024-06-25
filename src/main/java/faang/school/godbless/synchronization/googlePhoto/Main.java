package faang.school.godbless.synchronization.googlePhoto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final int THREAD_COUNT = 2;
    private static final int COUNT_PHOTO = 1000;


    public static void main(String[] args) {

        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        executorService.execute(googlePhoto::startAutoUpload);
        IntStream.range(1, COUNT_PHOTO)
                .forEach(i -> executorService.execute(() -> googlePhoto.onNewPhotoAdded("C:\\photo" + i + ".jpg")));

        executorService.shutdown();
    }
}
