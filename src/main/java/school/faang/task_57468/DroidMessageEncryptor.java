package school.faang.task_57468;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
