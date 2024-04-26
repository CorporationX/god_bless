package faang.school.godbless.Task_24;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader("lock",
                new ArrayList<>(Arrays.asList("OnePath", "AnotherPath")));

        Thread toLoadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread toViewPhotoThread = new Thread(() -> System.out.println(googlePhotosAutoUploader.getPhotosToUpload()));

        toViewPhotoThread.start();
        toLoadThread.start();

        toViewPhotoThread.join();
        toLoadThread.join();

    }
}
