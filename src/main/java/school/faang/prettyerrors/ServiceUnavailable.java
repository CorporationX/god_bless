package school.faang.prettyerrors;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
public class ServiceUnavailable extends RuntimeException {
    public ServiceUnavailable() {
        super("Сервис недоступен");
    }
}
