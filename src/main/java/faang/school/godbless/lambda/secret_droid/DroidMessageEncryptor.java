package faang.school.godbless.lambda.secret_droid;
@FunctionalInterface
public interface DroidMessageEncryptor {
    String encrypt(String word, int keyEncrypt);

}
