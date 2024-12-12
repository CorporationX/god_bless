package school.faang.task_46221;

@FunctionalInterface
public interface DroidMessageCryptoEngine {
    String encryptOrDecrypt(String message, int key);
}
