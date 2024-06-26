package faang.school.godbless.sprint_3.multithreading_synchronization.task_2_photo;

public class UpLoaderThread extends Thread {
    private final GooglePhotosAutoUploader googlePhoto;
    private String path;

    public UpLoaderThread(GooglePhotosAutoUploader googlePhoto, String nameThread) {
        super(nameThread);
//        System.out.println("name in UpLoaderThread(): " + this.getName());
        this.googlePhoto = googlePhoto;
    }

    public void upload(String path) {
//        System.out.println("name in upload(): " + this.getName());
        this.path = path;
        run();
    }

    @Override
    public void run() {
        // Здесь работает поток с именем UpLoad
        googlePhoto.onNewPhotoAdded(path);
    }

    @Override
    public synchronized void start() {
        if (path != null) {
            run();
        }
    }
}
