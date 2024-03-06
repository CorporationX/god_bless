package faang.school.godbless.googlephotos;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GooglePhotosAutoUploader implements Runnable {
    private final GooglePhoto USER_PHOTOS;

    public void startAutoUpload() throws InterruptedException {
        synchronized (USER_PHOTOS) {
            do {
                if (USER_PHOTOS.isEmpty()) {
                    USER_PHOTOS.wait();
                }
                uploadPhotos();
                USER_PHOTOS.notify();
            } while (USER_PHOTOS.isConstantUnloading());
        }
    }

    public void uploadPhotos() {
        USER_PHOTOS.getPHOTOS_TO_UPLOAD().forEach(photo -> System.out.println("Фотография находящаяся в директории: " + photo + " была выгружена"));
        USER_PHOTOS.getPHOTOS_TO_UPLOAD().clear();
    }

    @Override
    public void run() {
        synchronized (USER_PHOTOS) {
            try {
                startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}