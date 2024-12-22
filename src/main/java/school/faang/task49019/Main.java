package school.faang.task49019;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> photosToUpLoad = new ArrayList<>();

        GooglePhotosAutoUpLoader upLoader = new GooglePhotosAutoUpLoader(photosToUpLoad);

        Thread upLoadThread = new Thread(() -> upLoader.startAutoUpLoad());


        Thread photoAdderThread = new Thread(() -> {
            upLoader.onNewPhotoAdded("Photo10.jpg");
            upLoader.onNewPhotoAdded("Photo11.jpg");
            upLoader.onNewPhotoAdded("Photo12.jpg");
            upLoader.onNewPhotoAdded("Photo13.jpg");
            upLoader.onNewPhotoAdded("Photo14.jpg");
            upLoader.onNewPhotoAdded("Photo15.jpg");
        });
        upLoadThread.start();
        photoAdderThread.start();


    }
}
