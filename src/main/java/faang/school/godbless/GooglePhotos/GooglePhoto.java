package faang.school.godbless.GooglePhotos;

public class GooglePhoto {

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread uploaderThread = new Thread(uploader::startAutoUpload);
        uploaderThread.start();

        Thread photoAdderThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                uploader.onNewPhotoAdded(new Photo("photo1.jpg"));
                Thread.sleep(2000);
                uploader.onNewPhotoAdded(new Photo("photo2.jpg"));
                Thread.sleep(3000);
                uploader.onNewPhotoAdded(new Photo("photo3.jpg"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Поток был прерван при добавлении фотографии", e);
            }
        });
        photoAdderThread.start();

        try {
            uploaderThread.join();
            photoAdderThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Основной поток был прерван", e);
        }
    }
}
