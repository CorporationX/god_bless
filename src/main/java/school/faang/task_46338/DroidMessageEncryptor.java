package school.faang.task_46338;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
