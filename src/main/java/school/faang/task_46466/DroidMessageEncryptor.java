package school.faang.task_46466;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String process(String message, int key);
}
