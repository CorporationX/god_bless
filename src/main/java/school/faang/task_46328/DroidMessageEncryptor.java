package school.faang.task_46328;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String code(String message, int key);
}
