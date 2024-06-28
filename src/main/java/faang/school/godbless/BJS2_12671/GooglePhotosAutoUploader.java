package faang.school.godbless.BJS2_12671;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private List<String> photosToUpload = new ArrayList<>();
    private Object lock = new Object();

    public void uploadPhotos(){
        System.out.println("Uploading photos to Google photos ...");
    }

    public void startAutoUpload(){
            synchronized (lock){
                if(photosToUpload.isEmpty()){
                    try{
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                uploadPhotos();
                photosToUpload.clear();
                if(photosToUpload.isEmpty()){
                    System.out.println("list photo is Empty" + photosToUpload);
                }
            }
    }

    public void NewPhotoAdded(){
            synchronized (lock) {
                String photoPath = "some/new/photo/path";
                photosToUpload.add(photoPath);
                System.out.println("New photo adde: " + photoPath);
                lock.notify();
            }
    }
}
