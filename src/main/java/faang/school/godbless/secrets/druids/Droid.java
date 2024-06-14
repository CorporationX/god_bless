package faang.school.godbless.secrets.druids;

/**
 * Я правильно понял, что в этой задаче не обязательно было использовать лямбды?
 * Я даже сначала решил просто задачу, а только потом вспомнил про применение лямбд
 * и думал как это сделать.
 * **/
public class Droid {

    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncryptor messageEncryptor = (msg, k) -> {
            char[] charMessage = msg.toCharArray();
            for(int i = 0; i < charMessage.length; i++) {
                charMessage[i] += k;
            }
            return new String(charMessage);
        };
        return messageEncryptor.messageEncryptor(message, key);
    }

    public String receiveEncryptedMessage(String message, int key) {
        DroidMessageEncryptor messageEncryptor = (msg, k) -> {
            char[] charMessage = msg.toCharArray();
            for(int i = 0; i < charMessage.length; i++) {
                charMessage[i] -= k;
            }
            return new String(charMessage);
        };
        return messageEncryptor.messageEncryptor(message, key);
    }



}
