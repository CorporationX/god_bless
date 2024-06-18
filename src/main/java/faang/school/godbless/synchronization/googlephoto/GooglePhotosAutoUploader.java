package faang.school.godbless.synchronization.googlephoto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    @Getter
    private boolean uploadingOn = false;

    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhoto = new GooglePhotosAutoUploader();

        Thread autoUploadThread = new Thread(googlePhoto::startAutoUpload);
        autoUploadThread.start();

        List<String> newPhotos = new ArrayList<>();
        IntStream.range(1, 1000 + 1).forEach(i -> newPhotos.add("Фото " + i));
        Thread addPhotosThread = new Thread(() -> newPhotos.forEach(googlePhoto::addNewPhoto));
        addPhotosThread.start();


        Thread.sleep(5000);
        autoUploadThread.interrupt();
        System.out.println("Конец основаного потока");
    }

    public void startAutoUpload() {
        synchronized (photosToUpload) {
            System.out.println("Запускаем startAutoUpload");

            uploadingOn = true;
            try {
                while (uploadingOn) {
                    if (photosToUpload.isEmpty()) {
                        System.out.println("Список фото для загрузки пуст, ожидаем notify");
                        photosToUpload.wait();
                    }
                    System.out.println("Получили notify - приступаем к закгрузке фото");
                    uploadPhotos();
                }
            } catch (InterruptedException e) {
                uploadingOn = false;
                System.out.println("Поток автообновления прерван, автообновление выключено");
            }
        }
    }

    //onNewPhotoAdded - почему по заданию такое название?
    public void addNewPhoto(String photoPath) {
        synchronized (photosToUpload) {
            System.out.printf("Добавляем новое фото %s\n", photoPath);

            photosToUpload.add(photoPath);
            photosToUpload.notify();
        }
    }

    private void uploadPhotos() {
        System.out.println("Выполняем загрузку фотографий");

        photosToUpload.forEach(s -> System.out.printf("Фото %s загружено на сервер\n", s));
        photosToUpload.clear();
    }
}
