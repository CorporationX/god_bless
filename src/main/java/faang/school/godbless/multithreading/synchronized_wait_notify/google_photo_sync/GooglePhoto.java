package faang.school.godbless.multithreading.synchronized_wait_notify.google_photo_sync;

public class GooglePhoto {
    private GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

    public void addPhoto(Photo photo) {
        System.out.println("new photo saved to the gallery");
        uploader.onNewPhotoAdded(photo.getPath());
    }

    public void viewPhoto() {

    }

}
