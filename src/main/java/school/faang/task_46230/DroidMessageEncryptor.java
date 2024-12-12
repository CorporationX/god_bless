package school.faang.task_46230;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
