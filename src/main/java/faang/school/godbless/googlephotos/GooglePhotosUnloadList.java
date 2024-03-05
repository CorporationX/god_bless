package faang.school.godbless.googlephotos;

import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class GooglePhotosUnloadList implements Runnable {
    private final GooglePhoto USER_PHOTOS;

    public void onNewPhotoAdded(String photoPath) {
        synchronized (USER_PHOTOS) {
            USER_PHOTOS.setPhotosToUpload(photoPath);
        }
    }

    @Override
    public void run() {
        synchronized (USER_PHOTOS) {
            do {
                System.out.println("Введите путь к новому фото:");
                onNewPhotoAdded(new Scanner(System.in).nextLine());
                USER_PHOTOS.notify();
                try {
                    USER_PHOTOS.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } while (USER_PHOTOS.isConstantUnloading());
        }
    }
}