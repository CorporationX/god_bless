package school.faang.sprint_2.task_46288;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String msg, int encryptorKey);
}