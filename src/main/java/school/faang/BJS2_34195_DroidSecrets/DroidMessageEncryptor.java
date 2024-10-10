package school.faang.BJS2_34195_DroidSecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, Integer key);
}
