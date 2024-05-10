package faang.school.godbless.sprint2.BJS2_5388;

public class Droid {
    public String sendEncryptedMessage(String message, int secret) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
          StringBuilder result = new StringBuilder(msg);
          return result.reverse().toString();
        };

        return encryptor.encrypt(message, secret);
    }

    public String receiveEncryptedMessage(String message, int secret) {
        DroidMessageEncryptor decryptor = (msg, key) -> new StringBuilder(msg).reverse().toString();
        return decryptor.encrypt(message, secret);
    }
}
