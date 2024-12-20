package school.faang.google_foto;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();

        Thread uploaderThread = new Thread(autoUploader::startAutoUpload);

    }
}
