package faang.school.godbless.ThirdSprint.BJS2_24582;

import java.util.ArrayList;
import java.util.List;

public class GooglePhotosAutoUploader {

     List<String> photosToUpload = new ArrayList<>();

    public void startAutoUpload(){
        synchronized (photosToUpload)
    }
}
