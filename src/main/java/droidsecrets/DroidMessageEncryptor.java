package droidsecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String apply(String message, int encryptKey);
}
