package school.faang.droids_secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, Integer code);
}
