package faang.school.godbless.task.googlePhotoSync;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        GooglePhoto photo = new GooglePhoto("C:\\photos\\photo322.jpeg");

        Thread photosToUploadThreat = new Thread(autoUploader::startAutoUpload);
        Thread photoAdderThreat = new Thread(() -> autoUploader.onNewPhotoAdded(photo));

        photosToUploadThreat.start();
        photoAdderThreat.start();
    }
}
