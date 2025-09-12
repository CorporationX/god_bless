package school.faang.m2_1_functional_interfaces.droidssecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int encryptionKey);
}
