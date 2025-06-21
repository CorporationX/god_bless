package school.faang.ecology.exception;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(int id) {
        super("Company not found by %s".formatted(id));
    }
}
