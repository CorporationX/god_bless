package school.faang.googlephoto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        GooglePhotoAutoUploader uploader = new GooglePhotoAutoUploader();
        Thread producer = new Thread(() -> uploader.onNewPhotoAdded("C://new_photo.png"), "Producer");
        Thread consumer = new Thread(uploader::startAutoUpload, "Consumer");
        consumer.start();
        producer.start();

        try {
            consumer.join();
            producer.join();
        } catch (InterruptedException e) {
            log.error("Caught exception", e);
            throw new IllegalStateException("Thread interrupted", e);
        }
    }
}
