package school.faang.wizards.exception;

/**
 * @author Danil Pudovkin
 * @since 26.06.2025
 */
public class WinnerNotFoundException extends RuntimeException {
    public WinnerNotFoundException() {
        super("Среди школ не найден победитель");
    }
}
