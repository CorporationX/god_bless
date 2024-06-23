package faang.school.godbless.synch2;

import java.util.ArrayList;
import java.util.List;

public record GooglePhotosAutoUploader(Object lock, List<String> pathToPhotos) {
    private static final String MESSAGE_ADD_PHOTO = "Добавили фото ";
    private static final String MESSAGE_UPLOAD_PHOTO = " - Фото загружено на сервер Google Photos";
    private static final int FIRST_PHOTO_INDEX = 0;
    private static final String MESSAGE_LIST_EMPTY = "Список пуст";
    private static boolean flag = true;

    public GooglePhotosAutoUploader() {
        this(new Object(), new ArrayList<>());
    }

    public void startAutoUpload() {
        while (flag) {
            synchronized (lock) {
                if (pathToPhotos.isEmpty()) {
                    try {
                        System.out.println(MESSAGE_LIST_EMPTY);
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                uploadPhotos();
            }
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            pathToPhotos.add(photoPath);
            System.out.println(MESSAGE_ADD_PHOTO + photoPath);
            lock.notify();
        }
    }

    private void uploadPhotos() {
        while (!pathToPhotos.isEmpty()) {
            System.out.println(pathToPhotos.get(FIRST_PHOTO_INDEX) + MESSAGE_UPLOAD_PHOTO);
            pathToPhotos.remove(FIRST_PHOTO_INDEX);
        }
    }

    public void endAutoLoad() {
        flag = false;
    }
}
