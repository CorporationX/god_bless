package school.faang.secretsofdroids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String massage, int key);
}
