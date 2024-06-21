package faang.school.godbless.BJS2_12767;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();
        List<String> pathPhoto = List.of("path1", "path2", "path3", "path4", "path5", "path6", "path7", "path8");

        pathPhoto.forEach(
                path -> {
                    new Thread(googlePhotos::startAutoUpload).start();
                    new Thread(() -> googlePhotos.onNewPhotoAdded(path)).start();
                }
        );
    }
}

