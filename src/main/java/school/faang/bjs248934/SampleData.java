package school.faang.bjs248934;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SampleData {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        final Thread thr1 = new Thread(uploader::startAutoUpload);
        final Thread thr2 = new Thread(() -> uploader.addNewPhotos(generateRandomFilesList()));
        thr1.start();
        thr2.start();
    }

    private static List<String> generateRandomFilesList() {
        List<String> result = new ArrayList<>();
        Random random = new Random();
        int nextint;
        do {
            nextint = random.nextInt(50);
        } while (nextint < 1);
        for (int i = 1; i <= nextint; i++) {
            result.add("file" + i);
        }
        System.out.println("The files to process totally: " + result);
        return result;
    }
}
