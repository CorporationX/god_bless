package faang.school.godbless.BJS2_12656;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUpLoader {
    private final Object lock = new Object();
    private final List<String> photosToUpLoad = new ArrayList<>();

    public void startAutoUpLoad() {
        // можно и без sync блока потому что нет возможных конфликтов (добавим - обновим, наоборот, пофиг)

        while (true) {
            upLoadPhotos(photosToUpLoad);
        }
    }

    private void upLoadPhotos(List<String> photosToUpLoad) {
        synchronized (lock) {
            if (photosToUpLoad.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            for (var photo : photosToUpLoad) {
                System.out.println("Photo" + photo + " uploaded.");
            }

            photosToUpLoad.clear();
        }
    }


    public void onNewPhotoAdded(String photoPath){
        synchronized (lock) {
            photosToUpLoad.add(photoPath);
            lock.notify();
        }
    }
}