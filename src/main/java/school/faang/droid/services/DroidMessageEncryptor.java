package school.faang.droid.services;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
