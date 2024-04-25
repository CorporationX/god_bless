package faang.school.godbless.google_photo;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();

        Uploader uploader = new Uploader(autoUploader);
        Thread uploadThread = new Thread(uploader);

        Viewer viewer = new Viewer(autoUploader);
        Thread viewThread = new Thread(viewer);
        uploadThread.start();
        viewThread.start();
    }
}

