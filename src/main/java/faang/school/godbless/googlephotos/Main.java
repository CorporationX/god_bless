package faang.school.godbless.googlephotos;

public class Main {
    public static void main(String... args) {
        GooglePhoto photoUser = new GooglePhoto();
        photoUser.setPhotosToUpload("C:\\Users\\user\\Pictures\\Screenshots\\screenshot_1.jpg");
        Thread uploadThread;

        uploadThread = new Thread(new GooglePhotosAutoUploader(photoUser));
        uploadThread.start();

        Thread viewingThread = new Thread(new GooglePhotosUnloadList(photoUser));
        viewingThread.start();
    }
}