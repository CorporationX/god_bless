package faang.school.godbless.Google_Photo_sync;

import lombok.Data;

@Data
public class GooglePhoto {
    private String photoPath;
    private boolean isReadyToUpload;

    public GooglePhoto(String photoPath) {
        this.photoPath = photoPath;
    }
}
