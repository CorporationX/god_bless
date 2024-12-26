package school.faang.sprint_3.task_48976;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int START_SIZE = 8;
    private static final int SLEEP_FOR_ADDER = 3000;
    private static final int BOUND_FOR_RANDOM_GENERATOR = 6;

    private static final Random random = new Random();

    public static void main(String[] args) {
        List<String> photos = new ArrayList<>();

        for (int i = 1; i <= START_SIZE; i++) {
            photos.add("photo" + i);
        }

        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader(photos);

        Thread uploader = new Thread(() -> {
            while (true) {
                autoUploader.startAutoUpload();
            }
        });

        Thread adder = new Thread(() -> {
            int photosCount = photos.size();
            while (true) {
                try {
                    Thread.sleep(SLEEP_FOR_ADDER);
                } catch (InterruptedException e) {
                    System.out.println("Поток " + Thread.currentThread().getName() + " прервался");
                }

                for (int i = 0; i < random.nextInt(1, BOUND_FOR_RANDOM_GENERATOR); i++) {
                    autoUploader.onNewPhotoAdded("photo" +  photosCount++);
                }
            }
        });

        uploader.start();
        adder.start();
    }
}
