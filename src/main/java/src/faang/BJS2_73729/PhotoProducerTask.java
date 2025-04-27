package src.faang.BJS2_73729;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PhotoProducerTask implements Runnable {
    private final GooglePhotosAutoUploader googlePhotosAutoUploader;
    private final List<String> photosToAdd;

    @Override
    public void run() {
        for (String photo : photosToAdd) {
            googlePhotosAutoUploader.onNewPhotoAdded(photo);
        }
    }
}
