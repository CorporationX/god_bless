package faang.school.godbless.googlePhoto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class GooglePhoto {
    private List<String> photos = new ArrayList<>();

    public void uploadPhoto(List<String> photosToUpload) {
        new GooglePhotosAutoUploader(photosToUpload).startAutoUpload();
    }
}
