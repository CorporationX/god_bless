package school.faang.droid;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
