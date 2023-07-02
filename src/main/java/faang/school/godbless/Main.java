package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread watchThread = new Thread(() -> {
            while (true) {
                String photoPath = "path/to/new/photo.jpg";
                uploader.onNewPhotoAdded(photoPath);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        uploadThread.start();
        watchThread.start();
    }
}
