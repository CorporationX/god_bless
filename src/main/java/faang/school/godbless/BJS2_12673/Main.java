package faang.school.godbless.BJS2_12673;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
        Thread uploader = new Thread(googlePhoto::startAutoUpload);
        Thread viewer = new Thread(() -> {
            while (true) {
                googlePhoto.getPhotosToUpload().forEach(System.out::println);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        uploader.start();
        viewer.start();

        googlePhoto.onNewPhotoAdded("111");
        Thread.sleep(1000);
        googlePhoto.onNewPhotoAdded("222");
        Thread.sleep(1000);
        googlePhoto.onNewPhotoAdded("333");
        Thread.sleep(1000);
        googlePhoto.onNewPhotoAdded("444");
    }
}
