package faang.school.godbless.google_photo_sync;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GooglePhotosAutoUploader{
    private final Lock lock = new ReentrantLock();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload(){
        synchronized (lock){
            if (photosToUpload.isEmpty()){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            uploadPhotos();
        }
    }

    private void uploadPhotos(){
        Iterator<String> iterator = photosToUpload.iterator();
        while (iterator.hasNext()){
            String photo = iterator.next();
            System.out.println(photo + " uploaded");
            iterator.remove();
        }
    }

    public void onNewPhotoAdded(String photo){
        synchronized (lock) {
            photosToUpload.add(photo);
            lock.notify();
        }
    }
}