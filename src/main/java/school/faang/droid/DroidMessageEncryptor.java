package school.faang.droid;

/**
 * @author Danil Pudovkin
 * @since 11.06.2025
 */
@FunctionalInterface
public interface DroidMessageEncryptor {
    String handle(String message, int encryptionKey);
}
