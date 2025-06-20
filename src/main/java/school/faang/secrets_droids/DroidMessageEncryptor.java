package school.faang.secrets_droids;

@FunctionalInterface
public interface DroidMessageEncryptor {

    String encrypt(String message, int key);
}
