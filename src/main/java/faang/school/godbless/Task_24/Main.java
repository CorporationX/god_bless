package faang.school.godbless.Task_24;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader(
                new ArrayList<>(List.of("OnePath", "AnotherPath")));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(googlePhotosAutoUploader::startAutoUpload);
        executorService.execute(() -> System.out.println(googlePhotosAutoUploader.getPhotosToUpload()));

        executorService.shutdown();

    }
}
