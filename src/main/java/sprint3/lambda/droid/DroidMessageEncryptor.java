package sprint3.lambda.droid;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
