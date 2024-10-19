package school.faang.photosync;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        System.out.println("Введите ссылку: ");

        Thread thread1 = new Thread(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded(scanner.nextLine());
        });
        Thread threadAuto = new Thread(() -> {
            googlePhotosAutoUploader.startAutoUpload();

        });
        thread1.start();
        threadAuto.start();
    }
}



