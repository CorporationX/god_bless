package faang.school.godbless.googPhotoSync;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
        List<String> photos = List.of("photo1", "photo2", "photo3", "photo4");

        Thread uploadThread = new Thread(googlePhoto::startAutoUpload);
        uploadThread.start();
        for(var photo : photos) {
            Thread addPhoto = new Thread(() -> googlePhoto.onNewPhotoAdded(photo));
            addPhoto.start();
        }
    }
}
