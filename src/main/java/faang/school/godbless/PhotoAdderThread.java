package faang.school.godbless;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PhotoAdderThread implements Runnable {
    private final GooglePhotosAutoUploader uploader;
    private final String photoPath;

    @Override
    public void run() {
        uploader.newPhotosAdded(photoPath);
    }
}