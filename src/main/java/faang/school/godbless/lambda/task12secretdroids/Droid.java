package faang.school.godbless.lambda.task12secretdroids;

public class Droid {
    private String message;
    private int keyEnc;
    public void sendEncryptedMessage(String message, int keyEnc){
        DroidMessageEncryptor encryptor = (message, keyEnc) -> {
            char[] charMessage = message.toCharArray();
            char[] encrypted = new char[message.length()];
            for (char symbol: message.toCharArray()) {
                c
            }
        };
    }
}
