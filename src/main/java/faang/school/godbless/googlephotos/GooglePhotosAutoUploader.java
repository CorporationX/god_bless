package faang.school.godbless.googlephotos;

import java.util.ArrayList;
import java.util.List;
public class GooglePhotosAutoUploader {
    private final Object lock = new Object();
    List<String> photosToUpload = new ArrayList<>() {{
        add("photo1.jpg");
                add("photo2.jpg");
                add("photo3.jpg");
                add("photo4.jpg");
                add("photo5.jpg");
                add("photo6.jpg");
                add("photo7.jpg");
                add("photo8.jpg");
                add("photo9.jpg");
                add("photo10.jpg");
    }};

    public void startAutoUpload(){
        while(true){
            synchronized (lock) {
                    if (photosToUpload.isEmpty()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    uploadPhotos();
                    //send photos to google server GOOgle photo

                }
            }
    }

    public void uploadPhotos(){
            System.out.println("Uploading photos ...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("All photos were successfully uploaded to Google Photos");
            System.out.println(photosToUpload);
            photosToUpload.clear();
    }
    public void onNewPhotoAdded(String photoPath){
        synchronized (lock){
            System.out.println("Photo uploaded");
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

}
