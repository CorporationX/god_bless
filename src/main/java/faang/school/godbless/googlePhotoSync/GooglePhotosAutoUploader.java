package faang.school.godbless.googlePhotoSync;

import java.util.List;

public class GooglePhotosAutoUploader {
    private String lock;
    private List<String> photosToUpload = List.of("c:/first/1","c:/first/2", "c:/first/3","c:/first/4","c:/first/5");


    public void startAutoUpload( ) {
        if(photosToUpload.isEmpty()) {
            photosToUpload.notify();
        }
    }
}
