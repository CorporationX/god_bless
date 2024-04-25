package faang.school.godbless.google_photo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Viewer implements Runnable {

    private final GooglePhotosAutoUploader uploader;

    @Override
    public void run() {
        uploader.onNewPhotoAdded("\\path\\photo1.jpg");
    }
}
