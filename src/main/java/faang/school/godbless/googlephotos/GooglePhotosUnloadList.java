package faang.school.godbless.googlephotos;

import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class GooglePhotosUnloadList implements Runnable {
    private final GooglePhoto USER_PHOTOS;

    public void onNewPhotoAdded(String photoPath) {
        synchronized (USER_PHOTOS) {
            USER_PHOTOS.add(photoPath);
        }
    }

    @Override
    public void run() {
        synchronized (USER_PHOTOS) {
            do {
                System.out.println("Введите путь к новому фото:");
                onNewPhotoAdded(new Scanner(System.in).nextLine());
                System.out.println("Есть еще новые фото?");
            } while (new Scanner(System.in).nextBoolean());
            USER_PHOTOS.notify();
        }
    }
}