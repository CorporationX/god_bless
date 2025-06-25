package school.faang.recomendation.exception;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id) {
        super("User with id = %d not found".formatted(id));
    }
}
