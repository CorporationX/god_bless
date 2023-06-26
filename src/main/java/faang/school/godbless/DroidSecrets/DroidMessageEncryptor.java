package faang.school.godbless.DroidSecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    public String decodeMessage(String message, int key);
}
