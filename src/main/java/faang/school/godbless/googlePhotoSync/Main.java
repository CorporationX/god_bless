package faang.school.godbless.googlePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        Thread uploader = new Thread(googlePhotosAutoUploader::startAutoUpload);
        Thread inserter = new Thread(() ->
                getListOfPaths().forEach(googlePhotosAutoUploader::onNewPhotoAdded)
        );

        uploader.start();
        inserter.start();
    }

    public static List<String> getListOfPaths() {
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            resultList.add("path " + (i + 1));
        }

        return resultList;
    }
}
