package school.faang.bjs2_76380;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostAlreadyExistsException extends RuntimeException {
    public PostAlreadyExistsException(long id) {
        super(String.format("Post with id %d already exists", id));
        log.error("Post with id {} already exists", id);
    }
}
