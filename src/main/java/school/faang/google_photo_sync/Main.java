package school.faang.google_photo_sync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        for (int i = 1; i <= 2; i++) {
            Thread consumer = new Thread(() -> {
                try {
                    uploader.startAutoUpload();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Consumer-" + i);
            consumer.start();
        }

        for (int i = 1; i <= 3; i++) {
            Thread producer = new Thread(() -> {
                for (int j = 1; j <= 5; j++) {
                    String photo = "Photo_from_" + Thread.currentThread().getName() + "_" + j;
                    uploader.onNewPhotosAdded(photo);
                    try {
                        Thread.sleep(500 + (int) (Math.random() * 500));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }, "Producer-" + i);
            producer.start();
        }
    }
}
