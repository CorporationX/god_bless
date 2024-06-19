package faang.school.godbless.GooglePhotoSync;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();
        List<String> pathPhoto = List.of("path1", "path2", "path3", "path4", "path5", "path6", "path7", "path8");

        for (String path : pathPhoto) {
            Thread thread1 = new Thread(() -> {
                try {
                    googlePhotos.startAutoUpload();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread1.start();

            Thread thread2 = new Thread(() -> googlePhotos.onNewPhotoAdded(path));
            thread2.start();
        }
    }
}
