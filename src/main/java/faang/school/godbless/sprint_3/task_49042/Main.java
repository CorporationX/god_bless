package faang.school.godbless.sprint_3.task_49042;

public class Main {

    private static final int NUMBER_OF_PHOTOS = 4;

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread addingPhotos = new Thread(() -> {
            for (int i = 0; i < NUMBER_OF_PHOTOS; i++) {
                String photoPath = "path/to/photo/" + i + ".jpeg";
                googlePhotosAutoUploader.onNewPhotoAdded(photoPath);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread uploadingPhotos = new Thread(() -> {
            for (int i = 0; i < NUMBER_OF_PHOTOS; i++) {
                try {
                    googlePhotosAutoUploader.startAutoUpload();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        addingPhotos.start();
        uploadingPhotos.start();

        try {
            addingPhotos.join();
            uploadingPhotos.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
