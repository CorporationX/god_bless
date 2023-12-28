package Google;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        PhotoLoader photoLoader = new PhotoLoader(googlePhotosAutoUploader);

        Thread photoLoaderThread = new Thread(photoLoader);
        Thread photoUploaderThread = new Thread(() -> {
            //Пока поток-loader жив - выгружаем фотки
            while (photoLoaderThread.isAlive()) {
                try {
                    googlePhotosAutoUploader.startAutoUpload();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        photoLoaderThread.start();
        photoUploaderThread.start();

        photoLoaderThread.join();
        photoUploaderThread.join();
    }
}

