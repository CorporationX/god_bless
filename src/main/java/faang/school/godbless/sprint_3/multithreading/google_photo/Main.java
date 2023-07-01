package faang.school.godbless.sprint_3.multithreading.google_photo;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader google = new GooglePhotosAutoUploader();
        Thread second = new Thread(google::startAutoUpload);
        Thread first = new Thread(() -> google.oneNewPhotoAdded("new Photo.img"));
        second.start();
        first.start();
    }
}
