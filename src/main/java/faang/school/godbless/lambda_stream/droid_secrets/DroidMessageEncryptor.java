package faang.school.godbless.lambda_stream.droid_secrets;

interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
