package faang.school.godbless.DroidsSecrets;

@FunctionalInterface
public interface DroidMessageEncryptorOrDecrypt {
    String transform(String text, int cipherKey, EncryptorMethodName encryptorMethodName);
}

