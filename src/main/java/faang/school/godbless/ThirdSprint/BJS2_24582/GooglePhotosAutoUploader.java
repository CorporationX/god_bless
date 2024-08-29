package faang.school.godbless.ThirdSprint.BJS2_24582;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

     List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() throws InterruptedException {
        synchronized (photosToUpload){
            while (true){
            if(photosToUpload.isEmpty()){
                photosToUpload.wait();
            }
            uploadPhotos();
            }
        }
    }
    public void uploadPhotos(){
        photosToUpload.stream().forEach(s -> System.out.println(s + " is uploaded"));

        photosToUpload.clear();


    }

    public void onNewPhotoAdded(String photoPath){
        synchronized (photosToUpload){
            photosToUpload.add(photoPath);
            photosToUpload.notify();
            System.out.println(photoPath + " is ready to upload");
        }
    }
}
