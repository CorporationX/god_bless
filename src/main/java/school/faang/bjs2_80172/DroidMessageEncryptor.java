package school.faang.bjs2_80172;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int encryptKey);
}