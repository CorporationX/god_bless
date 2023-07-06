package faang.school.godbless.sprint3.droidsSecrets.interfaces;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String encryptedMessage, int encryptedKey);
}
