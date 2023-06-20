package faang.school.godbless.task.droids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptMessage(String message, int encryptKey);
}
