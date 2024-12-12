package school.faang.task_46190;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String run(String message, int encryptionKey);
}
