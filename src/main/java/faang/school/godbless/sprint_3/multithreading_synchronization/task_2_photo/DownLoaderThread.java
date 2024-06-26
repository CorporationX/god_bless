package faang.school.godbless.sprint_3.multithreading_synchronization.task_2_photo;

public class DownLoaderThread extends Thread {
    private final GooglePhotosAutoUploader googlePhoto;

    public DownLoaderThread(GooglePhotosAutoUploader googlePhoto, String nameThread) {
        super(nameThread);
        this.googlePhoto = googlePhoto;
    }

    @Override
    public void run() {
        try {
            googlePhoto.startAutoUpload();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
