package faang.school.godbless.GooglePhoto;

public class GooglePhoto {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotoUploader = new GooglePhotosAutoUploader();

        String path1 = "C:\\Users\\User\\Pictures\\TwitterAppPictures\\cb2995d0-7b5d-4e61-831c-6e1c53532d7d.Screenshot 2024-03-04 144517.png";
        String path2 = "C:\\Users\\User\\Pictures\\TwitterAppPictures\\cb2995d0-7b5d-4e61-831c-6e1c5335t4fd.Screenshot 2024-03-04 144344.png";
        String path3 = "C:\\Users\\User\\Pictures\\TwitterAppPictures\\cb2995d0-7b5d-4e61-831c-6e1c535r42f4.Screenshot 2024-03-04 1443437.png";

        Thread uploadThread = new Thread(() -> {
            try {
                googlePhotoUploader.onNewPhotoAdded(path1);
                googlePhotoUploader.onNewPhotoAdded(path2);
                googlePhotoUploader.onNewPhotoAdded(path3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread watchThread = new Thread(() -> {
            try {
                googlePhotoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        uploadThread.start();
        watchThread.start();
    }
}
