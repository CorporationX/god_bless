package school.faang.sprint3.task48900;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class PhotoReader implements Runnable {
    private static final String FILE_PATH_PREFIX = "C:\\photos\\image_";
    private final GooglePhotosAutoUploader uploader;
    private final int photosQty;
    private final int sleepTime;

    @SneakyThrows
    public void run() {
        String fileName;
        for (int i = 0; i < photosQty; i++) {
            fileName = FILE_PATH_PREFIX + i;
            uploader.onNewPhotoAdded(fileName);
            Thread.sleep(sleepTime);
        }
    }
}
