package school.faang.sprint2.task46400.model;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptDecrypt(String message, int key);
}
