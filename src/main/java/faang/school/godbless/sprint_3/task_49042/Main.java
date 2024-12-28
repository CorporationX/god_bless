package faang.school.godbless.sprint_3.task_49042;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread addingPhotos = new Thread(() -> {
            int photoNumber = 1;
            while (true) {
                String photoPath = "path/to/photo/" + photoNumber++ + ".jpeg";
                googlePhotosAutoUploader.onNewPhotoAdded(photoPath);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread uploadingPhotos = new Thread(() -> {
            while (true) {
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
