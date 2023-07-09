package faang.school.godbless.kxnvg.googlephoto;

import java.util.List;

public class GooglePhotoRunner {

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        List<String> photosPaths = List.of("C://photo/first.jpg", "C://photo/second.jpg", "C://photo/third.jpg",
                "C://photo/fourth.jpg", "C://photo/fifth.jpg", "C://photo/sixth.jpg", "C://photo/seventh.jpg",
                "C://photo/eighth.jpg", "C://photo/ninth.jpg", "C://photo/tenth.jpg");

        Thread thread1 = new Thread(uploader::startAutoUpload);
        Thread thread2 = new Thread(() -> photosPaths.forEach(photo -> uploader.onNewPhotoAdded(photo)));

        thread1.start();
        thread2.start();
    }
}
