package school.faang.bjs273880;

public class Main {
    private static final int SLEEP_DURATION_MS = 500;
    private static final int ITERATIONS = 10;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread autoUploaderThread = new Thread(uploader::startAutoUpload);
        Thread produceNewPhotosThread = new Thread(() -> {
            for (int i = 0; i < ITERATIONS; i++) {
                try {
                    Thread.sleep(SLEEP_DURATION_MS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                String photoName = String.format("Photo %d.jpg", i);
                uploader.onNewPhotoAdded(photoName);
            }
            uploader.stop();
            System.out.printf("Producer finished (%s)%n", Thread.currentThread().getName());
        });

        autoUploaderThread.start();
        produceNewPhotosThread.start();
        try {
            autoUploaderThread.join();
            produceNewPhotosThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer interrupted");
        }
        System.out.println("AutoUploader finished");
        System.out.println("ProduceNewPhotos finished");
    }
}
