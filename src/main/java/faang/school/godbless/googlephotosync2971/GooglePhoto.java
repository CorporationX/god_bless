package faang.school.godbless.googlephotosync2971;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GooglePhoto {
    @Getter
    private List<String> photosStorage;
    private static final GooglePhotosAutoUploader AUTO_UPLOADER = new GooglePhotosAutoUploader();

    public GooglePhoto() {
        this.photosStorage = new ArrayList<>();
    }

    public static void main(String[] args) {
        GooglePhoto myGooglePhotos = new GooglePhoto();
        ExecutorService googlePhotoExecutor = Executors.newFixedThreadPool(2);
        googlePhotoExecutor.execute(() -> {
            try {
                AUTO_UPLOADER.startAutoUpload(myGooglePhotos);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });
        AUTO_UPLOADER.onNewPhotoAdded("E:\\Pictures\\My dog.jpg");
        AUTO_UPLOADER.onNewPhotoAdded("E:\\Pictures\\Other dog.jpg");
        AUTO_UPLOADER.onNewPhotoAdded("E:\\Pictures\\Another dog.jpg");
        AUTO_UPLOADER.onNewPhotoAdded("E:\\Pictures\\Why do i love dogs (Explanation).jpg");
        googlePhotoExecutor.execute(() -> System.out.println(myGooglePhotos.getPhotosStorage()));
    }
}
