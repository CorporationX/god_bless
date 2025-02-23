package school.faang.task_61802;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(uploader::startAutoUpload);
        Thread photoAdderThread = new Thread(() -> {
            uploader.onNewPhotoAdded("nature.jpg");
            uploader.onNewPhotoAdded("sun.jpg");
        });

        List<Thread> threads = new ArrayList<>(List.of(uploadThread, photoAdderThread));
        threads.forEach(Thread::start);
    }
}
