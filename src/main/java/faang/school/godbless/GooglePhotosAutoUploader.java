package faang.school.godbless;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
@Getter
public class GooglePhotosAutoUploader {
    private final List<String> photosToUpload ;
    Object lock ;

    public void startAutoUpload(){
        synchronized (lock){
                if (photosToUpload.isEmpty()){
                    try {
                        wait();


                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        }
    }
}
