package LambdaStream.bc1693;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String messageCoder(String message, int cipherKey);
}
