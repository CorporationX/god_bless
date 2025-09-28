package school.faang.bjs2_90462;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(uploader::startAutoUpload);
        executor.execute(() -> {
            uploader.onNewPhotoAdded("fkdgdisghbjikhdsfbgk.jpg");
            uploader.onNewPhotoAdded("hjsdgfbakjdhf.png");
            uploader.onNewPhotoAdded("dfjhgbdfjhsfsvr.jpg");
            uploader.stopAutoUpload();
        });

        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            log.warn("Too long waiting time");
            executor.shutdownNow();
        }
    }
}
