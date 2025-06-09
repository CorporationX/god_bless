package school.faang.bjs2_80062_droid_encrypt;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String doCrypto(String message, int key);
}
