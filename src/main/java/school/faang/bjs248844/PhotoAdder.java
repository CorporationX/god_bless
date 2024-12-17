package school.faang.bjs248844;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PhotoAdder implements Runnable {
    GooglePhotosAutoUploader uploader;

    @Override
    public void run() {
        String photoPath;
        for (int i = 1; i <= 4; i++) {
            photoPath = "photo" + i;
            uploader.addNewPhoto(photoPath);
        }
    }
}