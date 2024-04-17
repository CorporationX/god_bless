package faang.school.godbless.GooglePhotoSync;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader(getStartPhotos());

        Thread viewer = new Thread(autoUploader::startAutoUpload);
        Thread uploader = new Thread(() -> autoUploader.onNewPhotoAdded(getNewPhotos()));

        viewer.start();
        Thread.sleep(5000);
        uploader.start();
    }

    private static List<String> getStartPhotos() {
        List<String> list = new ArrayList<>();
        list.add("/Users/username/Pictures/photo1.jpg");
        list.add("/home/username/Images/photo2.png");
        list.add("/mnt/data/photos/photo4.jpeg");
        list.add("/var/www/images/photo5.gif");
        return list;
    }

    private static List<String> getNewPhotos() {
        List<String> list = new ArrayList<>();
        list.add("/mnt/storage/images/photo6.jpg");
        list.add("/Users/username/Pictures/album/photo7.jpeg");
        list.add("/home/user1/photos/photo9.bmp");
        list.add("/var/www/html/images/photo10.tif");
        return list;
    }
}
