package school.faang.recomendation.exception;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(int userId) {
        super("Category for user with id = %d not found".formatted(userId));
    }
}
