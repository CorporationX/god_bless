package faang.school.godbless.BJS2_24453;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GooglePhotosAutoUploader {
    private final Object lock = new Object();

    private final List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + ": List of photos is empty... Need to wait.");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }

            uploadPhotos();
        }
    }

    public void onNewPhotoAdded() {
        synchronized (lock) {
            for (int i = 0; i< 10 ; i++) {
                String newPhoto = "New Photo " + new Random().nextInt(100);
                System.out.println(Thread.currentThread().getName() + ": added " + newPhoto);
                photosToUpload.add(newPhoto);
            }
            lock.notify();
        }
    }

    private void uploadPhotos() {
        String threadName = Thread.currentThread().getName();
        Iterator<String> iterator = photosToUpload.iterator();
        while (iterator.hasNext()) {
            System.out.println(threadName + ": Photo " + iterator.next() + " is uploaded to Google Disk");
            iterator.remove();
        }

        System.out.println(threadName + ": All photos uploaded");
        System.out.println(threadName + ": Photos list size is " + photosToUpload.size());
    }
}
