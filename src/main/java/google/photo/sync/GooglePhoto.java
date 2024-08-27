package google.photo.sync;

import lombok.Getter;

@Getter
public class GooglePhoto {
    private final String photoPath;

    public GooglePhoto(String photoPath) {
        this.photoPath = photoPath;
    }
}
