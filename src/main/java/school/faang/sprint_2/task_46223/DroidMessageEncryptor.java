package school.faang.sprint_2.task_46223;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int encryptionKey);
}
