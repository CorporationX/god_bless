package faang.school.godbless.BJS212648;

import java.util.Random;

import static faang.school.godbless.BJS212648.RepeaterUtil.repeat;

public class GooglePhoto {

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        new Thread(googlePhotosAutoUploader::startAutoUpload)
                .start();
        new Thread(() -> repeat(() -> new Random().nextInt(1, 6), () -> googlePhotosAutoUploader.onNewPhotoAdded("newPhoto")))
                .start();
    }

}
