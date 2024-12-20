package school.faang.sprint_3.task_bjs248925;

import java.util.List;

public class Main {
    private static final int INITIAL_FILES_CAPACITY = 10;

    public static void main(String[] args) {
        List<String> files = TestDataGenerator.generatePhotoPaths(INITIAL_FILES_CAPACITY);
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader(files);

        Thread autoUpload = new Thread(() -> {
            while (true) {
                autoUploader.startAutoUpload();
            }
        });
        Thread newPhotoAdder = new Thread(() -> {
            while (true) {
                autoUploader.addNewPhoto(TestDataGenerator.generateSinglePhotoPath());
            }
        });
        autoUpload.start();
        newPhotoAdder.start();
    }
}
