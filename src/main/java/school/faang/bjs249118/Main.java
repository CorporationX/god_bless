package school.faang.bjs249118;

public class Main {

    public static void main(String[] args) throws Exception {

        GooglePhotosAutoUploader photosUploader = new GooglePhotosAutoUploader();

        Thread consumer = new Thread(() -> {
            while (true) {
                photosUploader.startAutoUpload();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        }, "consumer");

        Thread producer = new Thread(() -> {
            int photoCounter = 1;
            while (true) {
                photosUploader.onNewPhotoAdded("test" + photoCounter++);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        }, "producer");

        consumer.start();
        producer.start();
    }

}
