package school.faang.task_46246;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
