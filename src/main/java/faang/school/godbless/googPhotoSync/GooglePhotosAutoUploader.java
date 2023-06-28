package faang.school.godbless.googPhotoSync;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GooglePhotosAutoUploader{
    final Object lock = new Object();
    private List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload() {
        synchronized (lock) {
            while (photosToUpload.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                uploadPhotos();
            }

        }

    }

    public void onNewPhotoAdded(String photoPath){
        synchronized (lock) {
            photosToUpload.add(photoPath);
            lock.notify();
        }
    }

    public void uploadPhotos(){
        for (String photo : photosToUpload){
            System.out.print(photo + ", ");
        }
        photosToUpload = new ArrayList<>();
        System.out.println("Фотографии выгружены и удалены с устройства");
    }
}
