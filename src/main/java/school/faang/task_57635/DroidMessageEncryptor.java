package school.faang.task_57635;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
