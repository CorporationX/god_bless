package school.faang.bjs248934;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SampleData {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        final Thread thr1 = new Thread(uploader::startAutoUpload);

        List<String> files = new ArrayList<>();
        Random random = new Random();
        int nextint;
        do {
            nextint = random.nextInt(20);
        } while (nextint < 1);
        for (int i = 1; i <= nextint; i++) {
            files.add("file" + i);
        }
        System.out.println("The files to process totally: " + files);
        final Thread thr2 = new Thread(() -> uploader.addNewPhotos(files));

        thr1.start();
        thr2.start();
    }
}
