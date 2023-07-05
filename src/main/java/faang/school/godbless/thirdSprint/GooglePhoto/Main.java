package faang.school.godbless.thirdSprint.GooglePhoto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        List<String> photos = List.of("я на море", "красивый закат", "мой обед");

        Thread thread1 = new Thread(uploader::startAutoUpload);

        Thread thread2 = new Thread(() -> {
            for (String photo : photos) {
                uploader.onNewPhotoAdded(photo);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
