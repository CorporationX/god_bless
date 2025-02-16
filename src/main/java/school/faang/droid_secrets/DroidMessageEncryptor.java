package school.faang.droid_secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
