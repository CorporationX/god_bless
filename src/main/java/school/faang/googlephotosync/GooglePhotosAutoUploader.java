package school.faang.googlephotosync;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;


@Getter
@Setter
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload = new ArrayList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition newPhotoCondition = lock.newCondition();
}
