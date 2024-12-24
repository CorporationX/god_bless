package school.faang.sprint3.task48900;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class PhotoUploader implements Runnable {
    private final GooglePhotosAutoUploader uploader;

    @SneakyThrows
    public void run() {
        uploader.startAutoUpload();
    }
}
