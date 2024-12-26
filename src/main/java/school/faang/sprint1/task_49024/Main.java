package school.faang.sprint1.task_49024;

public class Main {
    public static void main(String[] args) {

        GooglePhotosAutoUploader loader = new GooglePhotosAutoUploader();

        Thread autoUpLoad = new Thread(loader::startAutoUpload);
        Thread addPhoto = new Thread(() -> {
            loader.onNewPhotoAdded("photo1");
            loader.onNewPhotoAdded("photo2");
        });

        autoUpLoad.start();
        addPhoto.start();
    }
}
