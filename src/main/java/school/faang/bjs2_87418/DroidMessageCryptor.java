package school.faang.bjs2_87418;

@FunctionalInterface
public interface DroidMessageCryptor {
    String transform(String message, int encryptionKey);
}
