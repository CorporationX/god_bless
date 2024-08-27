package faang.school.godbless.droids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptDecryptMessage(String message, int key);
}
