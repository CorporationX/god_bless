package faang.school.godbless.bjs224595;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static final int SPACE_LIMIT = 15;

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread autoAdding = new Thread(() -> {
            while (count.get() <= SPACE_LIMIT) {
                googlePhotosAutoUploader.addNewPhoto("my_photo_" + count.getAndIncrement());
            }
        });

        Thread autoUploader = new Thread(googlePhotosAutoUploader::startAutoUpload);
        autoAdding.start();
        autoUploader.start();
    }
}