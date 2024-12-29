package school.faang.sprint3.bjs_48843;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        List<String> photos = List.of("photo1Path", "photo2Path", "photo3Path", "photo4Path");

        GooglePhotosAutoUploader myUpLoader = new GooglePhotosAutoUploader();
        Thread autoLoad = new Thread(myUpLoader::startAutoUpload);
        autoLoad.start();
        ExecutorService executor = Executors.newCachedThreadPool();
        photos.forEach(photo -> executor.submit(() -> myUpLoader.onNewPhotoAdded(photo)));
        executor.shutdown();
        autoLoad.join();
    }
}