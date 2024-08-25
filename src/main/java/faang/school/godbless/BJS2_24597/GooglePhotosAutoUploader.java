package faang.school.godbless.BJS2_24597;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GooglePhotosAutoUploader {
    private final Lock lock = new Lock();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            if (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            Iterator<String> iterator = photosToUpload.iterator();
            while (iterator.hasNext()) {
                String photoPath = iterator.next();
                uploadPhotos(photoPath);
                iterator.remove();
            }
        }
    }

    public void uploadPhotos(String photoPath) {
        System.out.println("Photo with the path " + photoPath + " is uploaded");
    }

    public void onNewPhotoAdded(String photoPath) {
        synchronized (lock) {
            photosToUpload.add(getSaltString());
            photosToUpload.add(getSaltString());
            photosToUpload.add(getSaltString());
            lock.notify();
        }
    }

    public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }

        String saltStr = salt.toString();
        return saltStr;
    }
}
