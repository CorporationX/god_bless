package faang.school.godbless.BJS2_24356;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
       synchronized (lock){
           try {
               while (true){
                   if (photosToUpload.isEmpty()) {
                       System.out.println("No photos, waiting");
                       lock.wait();
                   }
                   System.out.println("thread is alive!");
                   uploadPhotos();
               }
           } catch (InterruptedException e) {
               System.out.println("auto loader is turned off");
           }
       }
    }

    public void uploadPhotos(){
        synchronized (lock){
            System.out.println("Loading in Google cloud");
            photosToUpload.clear();
        }
    }

    public void onNewPhotoAdded(String photoPath){
       synchronized (lock){
           System.out.printf("adding %s to list%n", photoPath);
           photosToUpload.add(photoPath);
           lock.notify();
       }
    }
}
