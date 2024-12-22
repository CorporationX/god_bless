package school.faang.sprint_3.task_48932;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        GooglePhotosAutoUpdater googlePhotosAutoUpdater = new GooglePhotosAutoUpdater();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(googlePhotosAutoUpdater::startAutoUpload);
        executorService.submit(() -> googlePhotosAutoUpdater.onNewPhotoAdded("/path/to/image"));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
