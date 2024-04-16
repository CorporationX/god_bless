package faang.school.godbless.droidSecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptMessage(String message, int key);
}
