package school.faang.droidsecret.maincode;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
