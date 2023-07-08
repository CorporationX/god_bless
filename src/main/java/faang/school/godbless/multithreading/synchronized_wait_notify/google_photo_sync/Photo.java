package faang.school.godbless.multithreading.synchronized_wait_notify.google_photo_sync;

import lombok.Data;

@Data
public class Photo {
    private String name;
    private String path;

    public Photo(String name, String path) {
        this.name = name;
        this.path = path;
    }
}
