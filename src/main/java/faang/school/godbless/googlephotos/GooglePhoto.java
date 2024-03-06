package faang.school.godbless.googlephotos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class GooglePhoto {
    private final List<String> PHOTOS_TO_UPLOAD = new ArrayList<>();
    private boolean constantUnloading;

    public void setPhotosToUpload(String pathPhotos) {
        this.PHOTOS_TO_UPLOAD.add(pathPhotos);
    }

    public boolean isEmpty() {
        return PHOTOS_TO_UPLOAD.isEmpty();
    }
}