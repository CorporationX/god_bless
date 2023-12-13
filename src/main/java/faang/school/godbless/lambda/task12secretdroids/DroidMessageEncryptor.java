package faang.school.godbless.lambda.task12secretdroids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String message,int keyEnc);
}
