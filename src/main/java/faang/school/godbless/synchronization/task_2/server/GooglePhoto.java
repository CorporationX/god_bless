package faang.school.godbless.synchronization.task_2.server;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GooglePhoto {
    private final List<String> photos = new ArrayList<>();

    public void addPhoto(String photo) {
        synchronized (photos) {
            photos.add(photo);
            System.out.println(photo + " загружено в хранилище");
            photos.notify();
        }
    }

    public void showPhoto() {
        synchronized (photos) {
            while (photos.isEmpty()) {
                try {
                    photos.wait(3000);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                    e.printStackTrace();
                }
            }
            photos.forEach(System.out::println);
        }
    }
}