package src.faang.BJS2_73729;

import java.util.ArrayList;
import java.util.List;

public final class Main {
    private static final List<String> PHOTOS_PATH = new ArrayList<>();

    public static void main(final String[] args) {

        for (int i = 0; i < 10; i++) {
            PHOTOS_PATH.add("C:\\Users\\" + i + "\\Desktop\\" + i + ".jpg");
        }

        final GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        final Thread autoUploaderThread = new Thread(new PhotoConsumerTask(googlePhotosAutoUploader, PHOTOS_PATH));
        final Thread addingPhotosThread = new Thread(new PhotoProducerTask(googlePhotosAutoUploader, PHOTOS_PATH));

        autoUploaderThread.start();
        addingPhotosThread.start();
    }
}

