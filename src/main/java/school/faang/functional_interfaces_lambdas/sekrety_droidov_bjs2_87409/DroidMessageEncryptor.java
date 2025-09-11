package school.faang.functional_interfaces_lambdas.sekrety_droidov_bjs2_87409;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int encryptionKey);
}