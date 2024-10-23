package school.faang.Sprints.Multithreading_Synchronization.google_photo;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {
    private Object lock = new Object();
    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " come in");
            if (photosToUpload.isEmpty()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting");
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            uploadPhotos();
        }
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " add photo");
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    //Случалась ситуация, когда два потока отработали onNewPhotoAdded()
    //и в это время два других были в wait в startAutoUpload().
    //Получилось, что после notify один вывел две фотографии, а другой пустой список,
    //поэтому дважды спрашиваю, но уже в uploadPhotos(). Можно это сделать более красиво?

    private void uploadPhotos() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " job");
            photosToUpload.forEach(System.out::println);
            if (photosToUpload.isEmpty()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting");
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            photosToUpload.clear();
        }
    }
}
