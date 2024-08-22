package faang.school.godbless.googlePhoto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader(new Object(),
                new ArrayList<>(List.of(
                        "p1",
                        "p2",
                        "p3",
                        "p4",
                        "p5",
                        "p6",
                        "p7",
                        "p8",
                        "p9"
                ))
        );

        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(() -> {
            uploader.startAutoUpload();
        });


        Runnable newPath = () -> uploader.onNewPhotoAdded("new path");

        service.execute(newPath);
        service.execute(newPath);

        service.shutdown();

        service.awaitTermination(5, TimeUnit.SECONDS);//даеат время на окончание работы
        // и принудительно всё рушит, нужно для теста

        service.shutdownNow();
    }
}
