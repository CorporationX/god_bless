package GooglePhoto;

public class UploadPhoto {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread autoUploadThread = new Thread(googlePhotosAutoUploader::startAutoUpload);

        Thread addPhotosThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    String photoPath = "photo" + i + ".jpg";
                    googlePhotosAutoUploader.onNewPhotoAdded(photoPath);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.err.println("Поток добавления фотографий прерван: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        });

        autoUploadThread.start();
        addPhotosThread.start();
    }
}
