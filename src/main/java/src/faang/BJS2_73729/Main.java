package src.faang.BJS2_73729;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class Main {
    private static final List<String> PHOTOS_PATH = new ArrayList<>();
    private static final String PHOTO_PATH_TEMPLATE = "C:\\Users\\%d\\Desktop\\%d.jpg";
    private static final int SERVER_SHUTDOWN_TIME = 10;

    @SneakyThrows
    public static void main(final String[] args) {
        for (int i = 0; i < 10; i++) {
            PHOTOS_PATH.add(PHOTO_PATH_TEMPLATE.formatted(i, i));
        }

        final GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        final ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (String photo : PHOTOS_PATH) {
            executorService.execute(new PhotoProducerTask(googlePhotosAutoUploader, photo));
            executorService.execute(new PhotoConsumerTask(googlePhotosAutoUploader));
        }

        executorService.shutdown();

        if (executorService.awaitTermination(SERVER_SHUTDOWN_TIME, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}

