package faang.school.godbless.secretsOfDroid;
@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String msg, int key);
}
