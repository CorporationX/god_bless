package school.faang.bjs2_76380;

import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;

@Slf4j
public class PostNotFoundException extends NoSuchElementException {
    public PostNotFoundException(long id) {
        super(String.format("Post with id %d not found", id));
        log.error("Post with id {} not found", id);
    }
}
