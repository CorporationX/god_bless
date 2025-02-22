package school.faang.bjs2_61672;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread addPhoto = new Thread(() -> {
            int photoNumber = 1;
            while (photoNumber <= 10) {
                String photoPath = "photo_" + photoNumber + ".jpg";
                uploader.onNewPhotoAdded(photoPath);
                photoNumber++;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        Thread uploadPhoto = new Thread(uploader::startAutoUpload);

        addPhoto.start();
        uploadPhoto.start();

        try {
            addPhoto.join();
            uploader.stop();
            uploadPhoto.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Main thread interrupted.", e);
        }
    }
}
