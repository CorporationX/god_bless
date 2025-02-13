package school.faang.droids_secret;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
