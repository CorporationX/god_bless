package school.faang.bjs2_70588;

@FunctionalInterface
public interface DroidMessageEncryptor {
    public String encrypt(String message, Integer encryptionKey);
}
