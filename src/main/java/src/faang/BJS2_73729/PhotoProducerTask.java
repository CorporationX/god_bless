package src.faang.BJS2_73729;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PhotoProducerTask implements Runnable {
    private final GooglePhotosAutoUploader googlePhotosAutoUploader;
    private final String photoToAdd;

    @Override
    public void run() {
        googlePhotosAutoUploader.onNewPhotoAdded(photoToAdd);
    }
}
