package faang.school.godbless.BJS2_12671;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() ->
                uploader.startAutoUpload());

        Thread vievThread = new Thread(() ->
                uploader.NewPhotoAdded());

        uploadThread.start();
        vievThread.start();

    }
}
