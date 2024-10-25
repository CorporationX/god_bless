package school.faang.java.thread1.googlephoto;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private List<String> photosToUpload = new ArrayList<>();
    private final Object monitorDownloadPhoto = new Object();

    private final int workingTimeUploadPhoto = 100;
    private final int numberLoadedPhotos = 10;

    public void startAutoUpload() {
        synchronized (monitorDownloadPhoto){
            while (true) {
                if(photosToUpload.isEmpty()){
                    try {
                        System.out.println("startAutoUpload send: notify");
                        monitorDownloadPhoto.notify();
                        System.out.println("startAutoUpload: wait = on");
                        monitorDownloadPhoto.wait();
                        System.out.println("startAutoUpload: wait = off");
                    } catch (InterruptedException e) {
                        throw new IllegalStateException("EG001.001 - startAutoUpload");
                    }
                }else{
                    uploadPhotos();
                }
            }
        }
    }

    private void uploadPhotos(){
        photosToUpload.forEach(s -> workAction(workingTimeUploadPhoto));

        System.out.println("startAutoUpload: Read the list " + photosToUpload.size());
        photosToUpload = new ArrayList<>();
        System.out.println("startAutoUpload: remove All " + photosToUpload);
    }

    public void onNewPhotoAdded(){
        synchronized (monitorDownloadPhoto){
            while(true){
                for(int i = 0 ; i < numberLoadedPhotos; i++ ){
                    photosToUpload.add("Loaded photo #" + i);
                    workAction(workingTimeUploadPhoto);
                }
                System.out.println("onNewPhotoAdded: Created in List: " + photosToUpload.size());
                System.out.println("onNewPhotoAdded send: notify");
                monitorDownloadPhoto.notify();

                try {
                    System.out.println("onNewPhotoAdded: wait = on");
                    monitorDownloadPhoto.wait();
                    System.out.println("onNewPhotoAdded: wait = off");
                } catch (InterruptedException e) {
                    throw new IllegalStateException("EG003.001 - onNewPhotoAdded");
                }
            }
        }
    }

    private void workAction(int workingTime){
        try {
            Thread.sleep(workingTime);
        } catch (InterruptedException e) {
            throw new IllegalStateException("EG002.001 - workAction");
        }
    }
}