package faang.school.godbless.google_photo;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

@Data
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();

    @SneakyThrows
    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    lock.wait();
                }
                upLoadPhotos();
            }
        }

    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(photoPath);
            System.out.println(photoPath + " добавлено");
            lock.notify();

        }

    }

    public void upLoadPhotos() {
        for (String photo : photosToUpload) {
            System.out.println(photo + " загруженo в Google Photos");
        }
        photosToUpload.clear();


    }

}
