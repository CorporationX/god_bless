package faang.school.godbless.google_photo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Uploader implements Runnable {
    private GooglePhotosAutoUploader uploader;

    @Override
    public void run() {
        try {
            uploader.startAutoUpload();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
