package school.faang.bjs2_37440;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        String pathPhoto1 = "C:/Users/Misha/Pictures/photo1.jpg";
        String pathPhoto2 = "C:/Users/Misha/Pictures/vacation/photo2.jpg";
        String pathPhoto3 = "C:/Users/Misha/Pictures/events/birthday/photo3.jpg";

        Thread threadAutoUpload = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread threadNewPhotoAdded = new Thread(() -> Stream.of(pathPhoto1, pathPhoto2, pathPhoto3)
                .forEach(googlePhotosAutoUploader::onNewPhotoAdded));

        Stream.of(threadAutoUpload, threadNewPhotoAdded).forEach(Thread::start);
    }
}
