package school.faang.task_46278;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
