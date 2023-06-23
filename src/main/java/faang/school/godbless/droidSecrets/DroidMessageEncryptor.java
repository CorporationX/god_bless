package faang.school.godbless.droidSecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, Integer key);
}
