package school.faang.bjs2_76380;

import java.util.NoSuchElementException;

public class PostNotFoundException extends NoSuchElementException {
    public PostNotFoundException(long id) {
        super(String.format("Post with id %d not found", id));
    }
}
