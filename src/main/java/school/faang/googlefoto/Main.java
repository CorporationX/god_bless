package school.faang.googlefoto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        List<String> fotosList = List.of(
                "Foto21.png",
                "Foto22.png",
                "Foto23.png",
                "Foto24.png",
                "Foto25.png"
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
        Thread addPhotos = new Thread(() -> {
            fotos.forEach(autoUploader::onNewPhotoAdded);
        });

        uploadingPhotos.start();
        addPhotos.start();
    }
}
