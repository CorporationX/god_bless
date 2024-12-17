package school.faang.bjs248844;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PhotoAutoUploader implements Runnable {
    GooglePhotosAutoUploader uploader;

    @Override
    public void run() {
        uploader.startAutoUploadToServer();
    }
}
