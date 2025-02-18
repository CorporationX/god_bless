package school.faang.task_57626;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
