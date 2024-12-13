package school.faang.task_46238;

@FunctionalInterface
public interface DroidMessageEncryptor {

    String encrypt(String message, int key);
}
