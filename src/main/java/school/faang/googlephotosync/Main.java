package school.faang.googlephotosync;

public class Main {
    public static void main(String[] args) {
        GooglePhotoAutoUploader uploader = new GooglePhotoAutoUploader();

        Thread uploaderThread = new Thread(uploader::startAutoUpload, "Uploader-Thread");

        Thread producerThread = new Thread(() -> {
            String[] samplePhotos = {
                    "photo1.jpg",
                    "holiday/beach.png",
                    "family/reunion.jpeg",
                    "mountains/sunset.bmp"
            };
            try {
                for (String photo : samplePhotos) {
                    Thread.sleep(1000);
                    uploader.onNewPhotoAdded(photo);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток-добавитель прерван");
            }
        }, "Producer-Thread");

        uploaderThread.start();
        producerThread.start();
    }
}
