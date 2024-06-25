package faang.school.godbless.BJS2_12656;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> photos = new ArrayList<>();

        for (int i = 1; i < 1_000_000; i++) {
            photos.add("Photo " + i);
        }

        GooglePhotosAutoUpLoader googlePhoto = new GooglePhotosAutoUpLoader();

        Thread uploadPhoto = new Thread(googlePhoto::startAutoUpLoad);
        Thread addPhoto = new Thread(() -> {
            for (var photo : photos) {
                googlePhoto.onNewPhotoAdded(photo);
            }
        });

        uploadPhoto.start();
        addPhoto.start();
    }
}
