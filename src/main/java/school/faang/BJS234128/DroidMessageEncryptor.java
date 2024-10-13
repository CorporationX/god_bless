package school.faang.BJS234128;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptMessage(String msg, int encryptKey);
}
