package faang.school.godbless.googlePhotoSync;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();
        List<String> pathPhoto = List.of("c:/first/1","c:/first/2", "c:/first/3","c:/first/4","c:/first/5");

        for (String path : pathPhoto) {
            Thread thread = new Thread(() -> {
                try {
                    googlePhotos.startAutoUpload();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();

            Thread thread2 = new Thread(() -> {
                googlePhotos.onNewPhotoAdded(path);
            });
            thread2.start();
        }
    }
}