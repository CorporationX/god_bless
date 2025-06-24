package school.faang.bjs281984;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploade googlePhotos = new GooglePhotosAutoUploade();
        Thread[] threads = new Thread[2];
        threads[0] = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                googlePhotos.onNewPhotoAdded("Путь " + i);
            }
        });
        threads[1] = new Thread(() -> {
            try {
                googlePhotos.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        for (Thread thread : threads) {
            thread.start();
        }
    }
}

