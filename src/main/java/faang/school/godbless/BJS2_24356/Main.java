package faang.school.godbless.BJS2_24356;

public class Main {
    private static final int PHOTO_AMOUNT = 5;
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
        Thread loader = new Thread(googlePhoto::startAutoUpload);
        Thread observer = new Thread(() -> {
            for (int i = 1; i < PHOTO_AMOUNT; i++) {
                try {
                    Thread.sleep(2000);
                    googlePhoto.onNewPhotoAdded("photo number " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        loader.start();
        observer.start();

        Thread.sleep(10000);
        System.out.println("bb loader");
        loader.interrupt();
    }
}
