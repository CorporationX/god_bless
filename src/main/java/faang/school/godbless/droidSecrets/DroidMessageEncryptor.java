package faang.school.godbless.droidSecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String crypt(String message, Integer key);
}
