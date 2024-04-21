package faang.school.godbless.module.third.synchronization.google;

public class GooglePhoto {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread addPhotoThread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                uploader.onNewPhotoAdded(String.valueOf(i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread uploadPhotoThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            uploader.uploadPhotos();
            uploader.startAutoUpload();
            System.out.printf("Количество фоток в списке на загрузку %d %n", uploader.getPhotosToUpload().size());
        });
        addPhotoThread.start();
        uploadPhotoThread.start();
    }
}
