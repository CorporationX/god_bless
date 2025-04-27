package school.faang.bjs2_73900;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final GooglePhotosAutoUploader UPLOADER = new GooglePhotosAutoUploader();
    private static final Thread UPLOAD_PHOTO = new Thread(() -> UPLOADER.startAutoUpload());
    private static final Thread ADD_PHOTO_A = new Thread(() -> UPLOADER.onNewPhotoAdded("/home/user/god_bless_a"));
    private static final Thread ADD_PHOTO_B = new Thread(() -> UPLOADER.onNewPhotoAdded("/home/user/god_bless_b"));
    private static final Thread ADD_PHOTO_C = new Thread(() -> UPLOADER.onNewPhotoAdded("/home/user/god_bless_c"));

    public static void main(String[] args) {
        long sleepTime = 3_000;

        UPLOAD_PHOTO.start();
        ADD_PHOTO_A.start();
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        ADD_PHOTO_B.start();
        ADD_PHOTO_C.start();

        try {
            ADD_PHOTO_A.join();
            ADD_PHOTO_B.join();
            ADD_PHOTO_C.join();
            UPLOAD_PHOTO.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        log.info("All threads have finished.");
    }
}
