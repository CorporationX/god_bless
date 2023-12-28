package faang.school.godbless.BJS2_1145;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread uploadPhoto = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("picture of java");
            googlePhotosAutoUploader.onNewPhotoAdded("picture of jira");
            googlePhotosAutoUploader.onNewPhotoAdded("picture of github");
        });

        Thread uploadThread = new Thread(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("download aborted");;
            }
        });

        uploadThread.start();
        uploadPhoto.start();

        while (true) {
            if (!uploadPhoto.isAlive() && googlePhotosAutoUploader.getPhotosToUpload().isEmpty()) {
                uploadThread.interrupt();
                break;
            }
        }
    }
}
