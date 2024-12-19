package school.faang.sprint_3.task_bjs248925;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j

@AllArgsConstructor
public class GooglePhotosAutoUploader {
    private final Object lock;
    private final List<String> photosToUpload;
    private final AtomicBoolean exit = new AtomicBoolean(false);

    public void startAutoUpload() {
        while (!exit.get()) {
            synchronized (lock) {
                while (photosToUpload.isEmpty() && !exit.get()) {
                    try {
                        log.info("Thread is waiting...{}", Thread.currentThread().getName());
                        lock.wait();
                        log.info("thread {} catch exit wis value {}", Thread.currentThread().getName(), exit.get());
                    } catch (InterruptedException e) {
                        log.warn("Thread {} was interrupted", Thread.currentThread().getName());
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
            List<String> temp;
            synchronized (lock) {
                temp = new ArrayList<>(photosToUpload);
                photosToUpload.clear();
            }
            temp.forEach(photo -> log.info("Thread {} is uploading photo {}", Thread.currentThread().getName(), photo));
        }
    }

    public void setExit() {
        exit.set(true);
    }
}