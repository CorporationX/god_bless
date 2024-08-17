package droids.secrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String processMessage(String message, int key);
}
