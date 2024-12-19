package school.faang.sprint_3.task_bjs248925;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    private static final int FILES_CAPACITY = 10;
    private static final int FILES_TO_ADD_CAPACITY = 7;
    private static final int MILLIS_WAIT_ADDITIONAL_PHOTOS = 2000;
    private static final int MILLIS_WAIT_SHUTDOWN = 3000;
    private static final Object LOCK = new Object();
    private static int firstFileIndex = 0;

    public static void main(String[] args) {
        List<String> files = generateTestPhotoPaths(FILES_CAPACITY);
        List<String> filesToAdd = generateTestPhotoPaths(FILES_TO_ADD_CAPACITY);
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader(LOCK, files);

        Thread autoUpload = new Thread(autoUploader::startAutoUpload, "Autouploader");
        autoUpload.start();
        Thread newPhotoAdder = getNewPhotoAdder(files, filesToAdd, "Photoadder");
        newPhotoAdder.start();

        try {
            Thread.sleep(MILLIS_WAIT_SHUTDOWN);
            synchronized (LOCK) {
                autoUploader.setExit();
                LOCK.notifyAll();
                log.info("Set exit to true in thread {}", Thread.currentThread().getName());
            }
            newPhotoAdder.join();
            autoUpload.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static Thread getNewPhotoAdder(List<String> files, List<String> filesToAdd, String threadName) {
        return new Thread(() -> {
            try {
                Thread.sleep(MILLIS_WAIT_ADDITIONAL_PHOTOS);
                log.info("Start adding files thread {}", Thread.currentThread().getName());
                synchronized (LOCK) {
                    files.addAll(filesToAdd);
                    log.info("End adding files thread {} ", Thread.currentThread().getName());
                    LOCK.notifyAll();
                    log.info("thread {} notified all that new photos added", Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                log.error("Thread {} was interrupted", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
        }, threadName);
    }

    private static List<String> generateTestPhotoPaths(int capacity) {
        List<String> list = new ArrayList<>(capacity);
        for (int i = firstFileIndex; i < firstFileIndex + capacity; i++) {
            list.add("Photo" + i);
        }
        firstFileIndex += capacity;
        return list;
    }
}
