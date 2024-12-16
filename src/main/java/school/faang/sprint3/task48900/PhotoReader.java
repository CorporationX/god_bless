package school.faang.sprint3.task48900;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class PhotoReader implements Runnable{

    private final GooglePhotosAutoUploader uploader;
    private final int photosQty;
    private final int sleepTime;
    @SneakyThrows
    public void run()
    {
        String fileName;
        for (int i=0; i<photosQty; i++)
        {
            fileName = "C:\\photos\\image_"+i;
            uploader.onNewPhotoAdded(fileName);
            Thread.sleep(sleepTime);
        }
    }
}
