package school.faang.thirdStream.BJS2_37169;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        List<String> photos = List.of(
                "PhotoA.jpg",
                "PhotoB.jpg",
                "PhotoC.jpg",
                "PhotoD.jpg",
                "PhotoE.jpg",
                "PhotoF.jpg"
        );

        Thread photoUploader = new Thread(uploader::startAutoUpload);

        Thread photoAdder = new Thread(() -> {
            try {
                for (String photo : photos) {
                    Thread.sleep(2000);
                    uploader.onNewPhotoAdded(photo);
                }
            } catch (InterruptedException e) {
                System.out.println("Работа загрузчика была прервана");
                e.printStackTrace();
            }
        });

        photoUploader.start();
        photoAdder.start();
    }
}
