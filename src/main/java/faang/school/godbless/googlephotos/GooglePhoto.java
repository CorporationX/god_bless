package faang.school.godbless.googlephotos;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GooglePhoto {
    private final List<String> PHOTOS_TO_UPLOAD = new ArrayList<>();

    public void setPhotosToUpload(String pathPhotos) {
        this.PHOTOS_TO_UPLOAD.add(pathPhotos);
    }

    public boolean isEmpty() {
        return PHOTOS_TO_UPLOAD.isEmpty();
    }

    public void add(String path) {
        this.PHOTOS_TO_UPLOAD.add(path);
    }
}