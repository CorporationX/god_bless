package school.faang.bjs2_61672;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread addPhoto = new Thread(new Runnable() {
            @Override
            public void run() {
                int photoNumber = 1;
                while (true) {
                    String photoPath = "photo_" + photoNumber + ".jpg";
                    uploader.onNewPhotoAdded(photoPath);
                    photoNumber++;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        addPhoto.start();

        Thread uploadPhoto = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    uploader.startAutoUpload();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        uploadPhoto.start();

    }
}
