package school.faang.secretsofdroids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encryptOrDecrypt(String message, int key);
}
