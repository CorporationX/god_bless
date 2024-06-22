package faang.school.godbless.module1.sprint3.task9;

import java.util.LinkedList;
import java.util.List;


public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new LinkedList<>();


    public void startAutoUpload() throws InterruptedException {
        synchronized (photosToUpload) {
            if (photosToUpload.isEmpty()){
                System.out.println("wait");
                photosToUpload.wait();
            }
            for (String photo : photosToUpload) {
                System.out.println("execute uploadPhoto");
                uploadPhotos(photo);
            }
        }
    }

    private void uploadPhotos(String photo) {
        photosToUpload.remove(photo);
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (photosToUpload) {
            photosToUpload.add(photoPath);
            photosToUpload.notify();
        }
    }

}
