package faang.school.godbless.android;

@FunctionalInterface
public interface DroidMessageEncryptor {

    String encryptionMessage(String message, int keyEncryption);
}
