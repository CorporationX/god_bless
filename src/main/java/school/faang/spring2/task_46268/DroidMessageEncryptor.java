package school.faang.spring2.task_46268;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
