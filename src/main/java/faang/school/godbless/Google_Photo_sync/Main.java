package faang.school.godbless.Google_Photo_sync;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String PHOTO_PATH_1 = "Photo path 1";
    private static final String PHOTO_PATH_2 = "Photo path 2";
    private static final String PHOTO_PATH_3 = "Photo path 3";

    public static void main(String[] args) {

        GooglePhoto inputPhoto1 = new GooglePhoto(PHOTO_PATH_1);
        GooglePhoto inputPhoto2 = new GooglePhoto(PHOTO_PATH_2);
        GooglePhoto inputPhoto3 = new GooglePhoto(PHOTO_PATH_3);
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader(new Object(),
                new ArrayList<>());
        List<GooglePhoto> photosToLook = new ArrayList<>();

        new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            photosToLook.add(inputPhoto1);
            photosToLook.add(inputPhoto2);
            photosToLook.add(inputPhoto3);

            photosToLook.forEach(photo -> {
                photo.setReadyToUpload(true);
                System.out.printf("Фото %s просмотрено.\n", photo.getPhotoPath());
            });

            photosToLook.stream()
                    .filter(GooglePhoto::isReadyToUpload)
                    .forEach(photo -> uploader.onNewPhotoAdded(photo.getPhotoPath()));
        }).start();
    }
}
