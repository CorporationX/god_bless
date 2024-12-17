package school.faang.task_46237;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}