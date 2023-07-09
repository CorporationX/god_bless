package faang.school.godbless.spring_4.google_photo_sync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUpLoader upLoader = new GooglePhotosAutoUpLoader();

        String msg = "Synchronized statements are also useful for improving concurrency with fine-grained synchronization. Suppose";
        String[] url = msg.split(" ");

        Thread threadUpload = new Thread(() -> {
            for (String s : url) {
                upLoader.startAutoUpload();
            }
        });

        Thread threadAddPhotos = new Thread(() -> {
            for (String s : url) {
                upLoader.onNewPhotoAdded(s);
            }
        });

        threadAddPhotos.start();
        threadUpload.start();
        try {
            threadAddPhotos.join();
            threadUpload.join();
        } catch (InterruptedException e) {

        }

    }
}
