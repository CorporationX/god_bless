package faang.school.godbless.BJS2_24500;

import java.util.LinkedList;
import java.util.Queue;

public class GooglePhoto {
    public static void main(String[] args) {
        Queue<String> paths = new LinkedList<>();
        paths.add("/path/to/file1.txt");
        paths.add("/path/to/file2.txt");
        paths.add("/path/to/file3.jpg");
        paths.add("/path/to/file4.png");
        paths.add("/path/to/file5.docx");
        paths.add("/path/to/file6.mp4");
        paths.add("/path/to/file7.pdf");
        paths.add("/path/to/file8.csv");
        paths.add("/path/to/file9.zip");
        paths.add("/path/to/file10.exe");

        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Thread producer = new Thread(() -> {
            while (!paths.isEmpty()) {
                uploader.onNewPhotoAdded(paths.remove());
            }
        });
        Thread consumer = new Thread(uploader::startAutoUpload);

        producer.start();
        consumer.start();
    }
}
