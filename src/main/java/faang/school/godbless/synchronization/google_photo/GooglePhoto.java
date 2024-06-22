package faang.school.godbless.synchronization.google_photo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GooglePhoto {
    private static List<String> pathPhoto;
    private final static int MAX_COUNT_PATH_PHOTO = 50;
    private final static int MIN_COUNT_PATH_PHOTO = 1;

    public static void main(String[] args) throws InterruptedException {
        pathPhoto = getRandomPathPhoto();
        GooglePhotosAutoUploader photosUploader = new GooglePhotosAutoUploader();
        Thread photoAddTread = new Thread(() ->
                pathPhoto.forEach(photosUploader::onNewPhotoAdded));
        Thread photoUploadThread = new Thread(photosUploader::startAutoUpload);
        photoAddTread.start();
        photoUploadThread.start();
        Thread.sleep(1000L);
        if (photoAddTread.getState().equals(Thread.State.TERMINATED)) {
            System.out.println("Program end!");
            photosUploader.offAutoUpload();
        }
    }

    public static List<String> getRandomPathPhoto() {
        List<String> randomPathPhoto = new ArrayList<String>();
        int count = (int) (Math.random() * MAX_COUNT_PATH_PHOTO + MIN_COUNT_PATH_PHOTO);
        for (int i = 0; i < count; i++) {
            randomPathPhoto.add(String.format("Photo #%d path...", i));
        }
        return randomPathPhoto;
    }
}
