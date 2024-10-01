package google_photo_sync;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhotosRepository {
    private final List<String> photos = Collections.synchronizedList(new ArrayList<>());

    public void addPhotos(List<String> photos) {
        this.photos.addAll(photos);
    }

    public void printInfoAboutRepo() {
        System.out.printf("В хранилище находится фотографий: %d%n", photos.size());
    }
}
