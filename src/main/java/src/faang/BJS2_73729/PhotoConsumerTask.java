package src.faang.BJS2_73729;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PhotoConsumerTask implements Runnable {
    private final GooglePhotosAutoUploader googlePhotosAutoUploader;
    private final List<String> photosToUpload;

    @Override
    public void run() {
        for (int i = 0; i < photosToUpload.size(); i++) {
            googlePhotosAutoUploader.startAutoUpload();
        }
    }
}
