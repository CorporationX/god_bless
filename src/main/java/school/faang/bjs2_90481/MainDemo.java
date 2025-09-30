package school.faang.bjs2_90481;

public class MainDemo {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploaderThread = new Thread(() -> uploader.startAutoUpload(), "UPLOADER");

        Thread producerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("C:/photos/001.jpg");
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("C:/photos/002.jpg");
                Thread.sleep(1000);
                uploader.onNewPhotoAdded("C:/photos/003.jpg");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("PRODUCER завершил работу");
        }, "PRODUCER");

        uploaderThread.start();
        producerThread.start();

        try {
            producerThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while (uploaderThread.getState() != Thread.State.WAITING) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        uploader.requestStop();
        try {
            uploaderThread.join();
        } catch (InterruptedException e) {
            System.out.println("Остановлен");
        }
    }
}
