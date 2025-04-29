package src.faang.BJS2_73729;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PhotoConsumerTask implements Runnable {
    private final GooglePhotosAutoUploader googlePhotosAutoUploader;

    @Override
    public void run() {
        googlePhotosAutoUploader.startAutoUpload();
    }
}
