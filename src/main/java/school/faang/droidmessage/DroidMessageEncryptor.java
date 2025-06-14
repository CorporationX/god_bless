package school.faang.droidmessage;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
