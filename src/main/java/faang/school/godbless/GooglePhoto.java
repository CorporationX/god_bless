package faang.school.godbless;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GooglePhoto {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader(new Object());

        List<String> photos = List.of("photo1", "photo2", "photo3", "photo4", "photo5", "photo6",
                "photo7", "photo8", "photo9", "photo10", "photo11", "photo12",
                "photo13", "photo14", "photo15", "photo16");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(uploader::startAutoUpload);
        photos.forEach(photo -> {
            try {
                Thread.sleep(1000);
                executorService.execute(() -> {
                    uploader.onNewPhotoAdded(photo);
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.execute(uploader::uploadPhotos);
        executorService.shutdown();

        try {
           if( executorService.awaitTermination(5, TimeUnit.SECONDS)){
               log.info("finised ok");
           }
           else {
               log.info("finshed not ko");
           }
        } catch (InterruptedException e) {


        }
    }
}
