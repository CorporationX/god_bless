package school.faang.bjs_48984;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class UploadService {
    private static final int THREAD_POOL_SIZE = 2;
    private static final int TIMEOUT_SECONDS = 30;

    public List<String> upload(List<String> files) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<String> uploadedFiles = new ArrayList<>();

        Runnable uploadRunnable = () -> {
            List<String> upFiles = uploader.startAutoUpload();
            uploadedFiles.addAll(upFiles);
        };

        Runnable addPhotoRunnable = new Runnable() {
            public void run() {
                files.forEach(uploader::onNewPhotoAdded);
            }
        };

        executor.submit(uploadRunnable);
        executor.submit(addPhotoRunnable);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        uploader.stopAutoUpload();

        try {
            executor.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Upload interrupted", e);
        }

        executor.shutdown();

        return uploadedFiles;
    }
}
