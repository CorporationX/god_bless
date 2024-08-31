package faang.school.godbless.multithreading.synch.googlephoto;

public class GooglePhoto {
    public static void main(String[] args) {

        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();

        Thread downloadThread = new Thread(() -> {
            try {
                for (int i = 0; i <= 3; i++) {
                    String photoPath = "photo_" + i + ".jpg";
                    System.out.println("Adding new photo to list for download: " + photoPath);
                    googlePhoto.onNewPhotoAdded(photoPath);
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                System.out.println("Adding new photos was interrupted");
            }
        });

        Thread uploadThread = new Thread(googlePhoto::startAutoUpload);

        downloadThread.start();
        uploadThread.start();
    }
}
