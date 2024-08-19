package droidSecret;

@FunctionalInterface
public interface DroidMessageEncryptor {
    public String encrypt(String message, int code);
}
