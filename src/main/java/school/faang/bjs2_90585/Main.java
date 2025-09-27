package school.faang.bjs2_90585;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread photoAddThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                uploader.onNewPhotoAdded("photo" + i + ".jpg");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread autoUploadThread = new Thread(uploader::startAutoUpload);

        photoAddThread.start();
        autoUploadThread.start();
    }
}
