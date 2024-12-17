package school.faang.task_46320;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
