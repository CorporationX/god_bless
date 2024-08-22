package faang.school.godbless.DroidSecret;

@FunctionalInterface
public interface DroidMessageDecryptor {
    String decrypt(String decryptedMessage, int key);
}