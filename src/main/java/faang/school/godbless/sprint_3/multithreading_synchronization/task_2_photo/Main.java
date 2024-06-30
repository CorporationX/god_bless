package faang.school.godbless.sprint_3.multithreading_synchronization.task_2_photo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int COUNT_URLS = 100;
    private static final String MSG_ERROR = "Работа прервана.";
    private static final String MSG_EXIT = "Завершение работы.";


    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();
        List<String> urlsPhoto = new ArrayList<>();
        DownLoaderThread downLoader = new DownLoaderThread(googlePhoto, "Downloader");
        UpLoaderThread upLoader = new UpLoaderThread(googlePhoto, "Uploader", urlsPhoto);

        downLoader.start();
        upLoader.start();

        for (int i = 1; i <= COUNT_URLS; i++) {
            synchronized (urlsPhoto){
                urlsPhoto.add("ulr_" + i);
                Thread.sleep(200);
            }
        }

        try {
            Thread.sleep(2000);
            googlePhoto.setOff();
            Thread.sleep(1000);
            System.out.println(MSG_EXIT);
            System.exit(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(MSG_ERROR);
        }
    }
}
