package faang.school.godbless.google_photo;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        Thread upLoad = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread addPhoto = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String photo = "Photo_" + i + ".jpeg";
                googlePhotosAutoUploader.onNewPhotoAdded(photo);
            }
        });
        upLoad.start();
        addPhoto.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!addPhoto.isAlive() && googlePhotosAutoUploader.photosToUpload.isEmpty()) {
            upLoad.interrupt();
        }
        // иного метода найти не смог, а так заканчивается все исключением. Но вообще я не понимаю, зачем останавливать,
        // если, судя по задаче, это должен быть бесконечный процесс, когда программа ожидает новых фото и тут же загружает их
    }
}
