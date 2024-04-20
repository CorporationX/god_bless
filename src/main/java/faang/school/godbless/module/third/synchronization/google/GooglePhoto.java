package faang.school.godbless.module.third.synchronization.google;

public class GooglePhoto {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread addPhotoThread = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                uploader.onNewPhotoAdded(String.valueOf(i));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread uploadPhotoThread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.printf("Количество фоток в списке на загрузку %d %n", uploader.getPhotosToUpload().size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                uploader.startAutoUpload();
            }
            uploader.uploadPhotos();
        });
        addPhotoThread.start();
        uploadPhotoThread.start();
    }
}
