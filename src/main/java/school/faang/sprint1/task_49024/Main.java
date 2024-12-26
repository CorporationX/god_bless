package school.faang.sprint1.task_49024;

public class Main {
    public static void main(String[] args) {

        GooglePhotosAutoUploader loader = new GooglePhotosAutoUploader();

        Thread autoUpLoad = new Thread(() -> {
            while (true) {
                loader.startAutoUpload();
            }
        });
        Thread addPhoto = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                loader.onNewPhotoAdded("photo" + i);
            }

        });

        autoUpLoad.start();
        addPhoto.start();
    }
}
