package faang.school.godbless.domain.task_google_photo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static faang.school.godbless.domain.task_google_photo.application.SPLITTER;

public class GooglePhotosAutoUploader {

    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUploadPhotosToServer() throws InterruptedException {
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()) {
                photosToUpload.wait();
            }
            uploadPhotosOnServer();
        }
    }

    public void uploadPhotosOnServer() {
        System.out.println("Загрузка фотографий на сервер: ");

        Iterator<String> iterator = photosToUpload.iterator();

        while (iterator.hasNext()) {
            String photo = iterator.next();
            System.out.println(SPLITTER + photo + " загружена на сервер");
            iterator.remove();
        }
    }

    public void loadPhotoToMemory(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            System.out.println(SPLITTER + photoPath + " загружена в память");
            photosToUpload.notify();
        }
    }
}
