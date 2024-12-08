package school.faang.task_46191;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
