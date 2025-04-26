package school.faang.googlefoto;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        List<String> photosList = List.of(
                "Photo21.png",
                "Photo22.png",
                "Photo23.png",
                "Photo24.png",
                "Photo25.png"
        );

        autoUploader.getPhotosToUpload().addAll(photosList);

        List<String> photos = List.of(
                "Photo1.png",
                "Photo2.png",
                "Photo3.png",
                "Photo4.png",
                "Photo5.png",
                "Photo6.png",
                "Photo7.png",
                "Photo8.png",
                "Photo9.png",
                "Photo10.png",
                "Photo11.png",
                "Photo12.png",
                "Photo13.png",
                "Photo14.png",
                "Photo15.png",
                "Photo16.png",
                "Photo17.png"
        );

        autoUploader.managementProgram();

        Thread uploadingPhotos = new Thread(autoUploader::startAutoUpload);
        Thread addPhotos = new Thread(() -> photos.forEach(autoUploader::onNewPhotoAdded));

        uploadingPhotos.start();
        addPhotos.start();

        Thread.sleep(8000);

        autoUploader.managementProgram();
        uploadingPhotos.join();

        log.info("Поток main завершен");
    }
}