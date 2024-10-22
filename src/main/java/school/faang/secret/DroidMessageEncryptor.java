package school.faang.secret;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, Integer key);
}
