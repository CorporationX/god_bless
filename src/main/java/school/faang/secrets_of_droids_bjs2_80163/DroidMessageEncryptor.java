package school.faang.secrets_of_droids_bjs2_80163;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
