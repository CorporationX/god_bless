package school.faang.bjs2_76380;

public class PostAlreadyExistsException extends RuntimeException {
    public PostAlreadyExistsException(long id) {
        super(String.format("Post with id %d already exists", id));
    }
}
