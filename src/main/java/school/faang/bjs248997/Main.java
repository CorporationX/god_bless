package school.faang.bjs248997;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread serverGoogle = new Thread(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " is interrupt. Thread end work");
            }
        });

        Thread user = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                googlePhotosAutoUploader.onNewPhotoAdded("Photo " + i + " was added by the user");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName() + " is interrupt. Thread ended work");
                }
            }
        });

        serverGoogle.start();
        user.start();
    }
}
