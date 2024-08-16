package faang.school.godbless.DroidsSecrets;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String cipher(String text, int cipherKey, String methodName);
}

