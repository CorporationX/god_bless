package school.faang.task_48968;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String newPhoto = "c/pc/new";
        String newPhoto2 = "c/pc/new2";
        String newPhoto3 = "c/pc/new3";
        List<String> list = new ArrayList<>();
        list.add(newPhoto);
        list.add(newPhoto2);
        list.add(newPhoto3);

        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader(list);
        Thread automaticLoading = new Thread(() -> googlePhotosAutoUploader.startAutoUpload());
        Thread addNewPhotos = new Thread(() -> googlePhotosAutoUploader.onNewPhotoAdded(newPhoto));
        automaticLoading.start();
        addNewPhotos.start();
    }
}
