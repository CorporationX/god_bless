package faang.school.godbless.BJS2_24546;

import java.util.Random;

public class Main {

    private static final GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
    private static final Random random = new Random();

    public static void main(String[] args) {

        int photoCount = random.nextInt(100) + 10;

        Thread uploadPhoto = new Thread(googlePhoto::startAutoUpload);
        Thread addPhoto = new Thread(() -> {
            for (int i = 0; i < photoCount; i++) {
                System.out.println("Photo's count - " + photoCount);
                googlePhoto.onNewPhotoAdded("url" + i);
            }
        });

        addPhoto.start();
        uploadPhoto.start();
    }
}
