package school.faang.bjs2_73767;

import java.util.NoSuchElementException;

public class VideoNotFoundException extends NoSuchElementException {
    public VideoNotFoundException(String id) {
        super(String.format("Video with %s not found", id));
    }
}
