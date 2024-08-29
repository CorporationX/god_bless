package faang.school.godbless;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AutoUploaderThread implements Runnable {
    private final GooglePhotosAutoUploader autoUploader;

    @Override
    public void run() {
        autoUploader.startAutoUpload();
    }
}