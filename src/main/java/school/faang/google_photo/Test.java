package school.faang.google_photo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        List<String> paths = new ArrayList<>(List.of("path1", "path2", "path3", "path4", "path5"));

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        IntStream
                .range(0, 5)
                .mapToObj((object) -> new Thread(() -> paths.forEach(uploader::onNewPhotoAdded)))
                .forEach(Thread::start);
        IntStream
                .range(0, 10)
                .mapToObj((object) -> new Thread(uploader::startAutoUpload))
                .forEach(Thread::start);


    }
}
