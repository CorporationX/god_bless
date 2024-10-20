package school.faang.googlephotosync;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        GooglePhotosAutoUploader gpa = new GooglePhotosAutoUploader();

        Thread uploadThread = new Thread(() -> {
            try {
                gpa.startToUpload();
            } catch (InterruptedException e) {
                throw new IllegalStateException("Проблема с потоком" + e.getMessage());
            }
        });

        Thread addNewPhotoThread = new Thread(() -> {
            try {
                gpa.onNewPhotoAdded();
            } catch (InterruptedException e) {
                throw new IllegalStateException("Проблема с потоком" + e.getMessage());
            }
        });

        uploadThread.start();
        addNewPhotoThread.start();

        uploadThread.join();
        addNewPhotoThread.join();
    }
}
