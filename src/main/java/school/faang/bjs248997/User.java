package school.faang.bjs248997;

public class User implements Runnable {
    private final GooglePhotosAutoUploader googlePhotosAutoUploader;

    public User(GooglePhotosAutoUploader googlePhotosAutoUploader) {
        this.googlePhotosAutoUploader = googlePhotosAutoUploader;
    }

    @Override
    public void run() {
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
    }
}
