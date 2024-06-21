package faang.school.godbless.GooglePhoto;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        List<String> pathToPhoto = List.of("c:/first/1","c:/first/2", "c:/first/3","c:/first/4","c:/first/5");

        for (String path : pathToPhoto) {
            Thread thread = new Thread(() -> {
                try {
                    uploader.startAutoUpload();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();

            Thread thread2 = new Thread(() -> {
                uploader.onNewPhotoAdded(path);
            });
            thread2.start();
        }
    }

}
