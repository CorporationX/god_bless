package school.faang.godbless.bjs2_37179;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int PHOTOS_IN_CHUNK = 20;

    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploaderThread = new Thread(() -> {
            while (true) {
                uploader.startAutoUpload();
            }
        });
        uploaderThread.setName("uploader");
        uploaderThread.start();

        Thread adderThread = new Thread(
                () -> {
                    while (true) {
                        IntStream.rangeClosed(1, PHOTOS_IN_CHUNK)
                                .forEach(i -> uploader.onNewPhotoAdded("photo" + i));
                        Thread.yield();
                    }
                }
        );
        adderThread.setName("adder");
        adderThread.start();

        uploaderThread.join();
        adderThread.join();
    }
}
