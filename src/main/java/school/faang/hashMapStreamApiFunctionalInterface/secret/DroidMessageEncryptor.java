package school.faang.hashMapStreamApiFunctionalInterface.secret;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, Integer key);
}
