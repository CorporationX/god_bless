package school.faang.sprint_3.bjs2_37372_googlePhotoSynch;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<String> fruitPhotos = List.of("Apple", "Banana", "Orange", "Mango", "Peach", "Grapes", "Strawberry",
                "Blueberry", "Kiwi", "Pineapple");
        List<String> carPhotos = List.of("Toyota", "BMW", "Mercedes", "Honda", "Tesla", "Ford", "Chevrolet", "Audi",
                "Lexus", "Volkswagen");
        GooglePhotosAutoUploader photoUploader = new GooglePhotosAutoUploader(fruitPhotos);

        Thread uploadThread = new Thread(photoUploader::startAutoUpload);
        Thread addPhotosThread = new Thread(() -> {
            for (String carPhoto : carPhotos) {
                photoUploader.onNewPhotoAdded(carPhoto);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.error("Произошла ошибка во время задержки потока", e);
                    throw new RuntimeException(e);
                }
            }
        });

        uploadThread.start();
        addPhotosThread.start();

        for (Thread thread : Arrays.asList(uploadThread, addPhotosThread)) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Возникла ошибка при завершении потока.", e);
                throw new RuntimeException(e);
            }
        }
    }
}
