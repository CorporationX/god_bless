package school.faang.spam;

/**
 * @author Danil Pudovkin
 * @since 11.06.2025
 */
@FunctionalInterface
public interface MessageFilter {
    boolean filter(String message);
}
