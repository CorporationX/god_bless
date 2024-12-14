package school.faang.task_46528;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int keyEncrypt);
}
