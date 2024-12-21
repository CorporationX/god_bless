package school.faang.task_48878;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        var uploader = new GooglePhotosAutoUploader();

        Thread autoUploadThread = new Thread(uploader::startAutoUpload);
        Thread addPhotoThread = new Thread(() -> {
            uploader.onNewPhotoAdded("photo1");
            uploader.onNewPhotoAdded("photo2");
            uploader.onNewPhotoAdded("photo3");
            uploader.onNewPhotoAdded("photo4");
            uploader.onNewPhotoAdded("photo5");
            uploader.onNewPhotoAdded("photo6");
            uploader.onNewPhotoAdded("photo7");
            uploader.onNewPhotoAdded("photo8");
        });

        autoUploadThread.start();
        addPhotoThread.start();

        autoUploadThread.join();
        addPhotoThread.join();

    }
}
