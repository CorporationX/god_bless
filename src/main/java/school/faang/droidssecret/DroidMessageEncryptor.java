package school.faang.droidssecret;

@FunctionalInterface
public interface DroidMessageEncryptor {

    String encrypt(String message, int key);
}
