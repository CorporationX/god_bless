package school.faang.googlefoto;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        List<String> fotosList = List.of(
                "Foto21.png",
                "Foto22.png",
                "Foto23.png",
                "Foto24.png",
                "Foto25.png",
                "Foto26.png",
                "Foto27.png",
                "Foto28.png",
                "Foto29.png",
                "Foto30.png",
                "Foto31.png",
                "Foto32.png",
                "Foto33.png"
        );

        autoUploader.getPhotosToUpload().addAll(fotosList);

        List<String> fotos = List.of(
                "Foto1.png",
                "Foto2.png",
                "Foto3.png",
                "Foto4.png",
                "Foto5.png",
                "Foto6.png",
                "Foto7.png",
                "Foto8.png",
                "Foto9.png",
                "Foto10.png",
                "Foto11.png",
                "Foto12.png"
        );

        Thread uploadingPhotos = new Thread(autoUploader::startAutoUpload);
        Thread addPhotos = new Thread(() -> fotos.forEach(autoUploader::onNewPhotoAdded));

        uploadingPhotos.start();
        addPhotos.start();

        Thread.sleep(10000);

        uploadingPhotos.interrupt();
        log.info("Поток main завершен");
    }
}