package faang.school.godbless.BJS2_12657;

import java.util.Arrays;
import java.util.List;

public class GooglePhoto {
    public static void main(String[] args) {
        List<String> photos = Arrays.asList("MyPhoto", "LandscapePhoto", "Mom's portrait", "Wedding photo", "Birth Day");
        List<String> newPhotos = Arrays.asList("My Best Friend", "Driving", "First step", "Happiest moment", "Pool day");
        GoogleAutoUploader googlePhoto = new GoogleAutoUploader();
        Thread loadThread = new Thread(() -> googlePhoto.loadPhotosPool(photos));
        Thread firstThread = new Thread(googlePhoto::startAutoUpload);
        Thread secondThread = new Thread(() -> newPhotos.forEach(googlePhoto::onNewPhotoAdded));
        loadThread.start();
        firstThread.start();
        secondThread.start();
    }
}
