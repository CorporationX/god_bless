package faang.school.godbless.DroidSecrets;

@FunctionalInterface
public interface DroidMessageEncryption {
    String encrypt(String message, Integer encryptionKey);
}
