package derschrank.sprint03.task06.bjstwo_48908;

import java.util.ArrayList;
import java.util.List;


public class GooglePhotosAutoUploader implements GooglePhotosAutoUploaderInterface {
    private final List<String> photosToUpload;
    private final Object lock;

    private boolean autoUploadingModeFlag;

    public GooglePhotosAutoUploader() {
        photosToUpload = new ArrayList<>();
        lock = new Object();
    }

    @Override
    public void startAutoUpload() {
        autoUploadingModeFlag = true;
        while (autoUploadingModeFlag) {
            synchronized (lock) {
                while (photosToUpload.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("AutoUploader is interrupted");
                    }
                }
                System.out.println(" - Uploading was started:");
                uploadPhotos();
                System.out.println(" - Uploading was ended:");
            }
        }
    }

    @Override
    public void stopAutoUpload() {
        autoUploadingModeFlag = false;
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    @Override
    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            if (photosToUpload.add(photoPath)) {
                System.out.println("Photo was added to list for upload: " + photoPath + " [ " + Thread.currentThread().getName() + " ]");
                lock.notify();
            }
        }
    }

    @Override
    public void uploadPhotos() {
        for (String photoPath : photosToUpload) {
            System.out.println(" - Photo uploading: " + photoPath  + " [ " + Thread.currentThread().getName() + " ]");
        }
        photosToUpload.clear();
    }
}
