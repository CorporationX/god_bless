package faang.school.godbless.lambda;


public class Droid {

    public String sendEncryptedMessage(String message, int keyCrypt) {
        DroidMessageEncryptor droidMessageEncryptor = (message1, key) -> {
            StringBuilder sb = new StringBuilder();

            for (char c : message.toCharArray()) {
                sb.append((char) (c + keyCrypt));
            }
            return sb.toString();
        };
        return droidMessageEncryptor.encryptor(message, keyCrypt);

    }

    public String receiveEncryptedMessage(String message, int keyCrypt) {
        DroidMessageEncryptor droidMessageEncryptor = (message1, key) -> {

            StringBuilder sb = new StringBuilder();
            for (char c : message.toCharArray()
            ) {
                sb.append((char) (c - keyCrypt));
            }
            return sb.toString();
        };
        return droidMessageEncryptor.encryptor(message, keyCrypt);
    }
}
