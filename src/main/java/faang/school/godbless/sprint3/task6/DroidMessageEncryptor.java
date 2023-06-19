package faang.school.godbless.sprint3.task6;

@FunctionalInterface
public interface DroidMessageEncryptor {

    String encrypt(String message, int encryptionKey);
}
