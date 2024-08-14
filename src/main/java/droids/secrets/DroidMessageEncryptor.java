package droids.secrets;

public interface DroidMessageEncryptor {
    String processMessage(String message, int key);
}
