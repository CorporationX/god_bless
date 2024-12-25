package derschrank.sprint03.task06.bjstwo_48908;

import java.util.List;

public interface GooglePhotosAutoUploaderInterface {
    void startAutoUpload();

    void stopAutoUpload();

    void onNewPhotoAdded(String photoPath);

    void uploadPhotos();

}
