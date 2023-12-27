package faang.school.godbless.google_photo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>();


    public void startAutoUpload() {
        while (true) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
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
    // вот такие пустые строки у меня сами появляются. Это про них вопрос был?
}
