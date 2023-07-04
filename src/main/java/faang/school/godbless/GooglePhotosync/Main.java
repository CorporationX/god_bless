package faang.school.godbless.GooglePhotosync;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader autoUploader = new GooglePhotosAutoUploader();
        Scanner scanner = new Scanner(System.in);


        Thread photoProducer;
        Thread photoConsumer = new Thread(() -> autoUploader.startAutoUpload());
        photoConsumer.start();

        while (true) {
            String photoPath = scanner.nextLine();
            photoProducer = new Thread(() -> autoUploader.onNewPhotoAdded(photoPath));
            photoProducer.start();
        }
    }
}
