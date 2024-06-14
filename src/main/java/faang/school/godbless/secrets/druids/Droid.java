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
                char c = charMessage[i];
                if(Character.isLetter(c)) {
                    if (Character.isLowerCase(c)) {
                        charMessage[i] = (char) ('a' + (c - 'a' + k) % 26);
                    } else if (Character.isUpperCase(c)) {
                        charMessage[i] = (char) ('A' + (c - 'A' + k) % 26);
                    }
                }
            }
            return new String(charMessage);
        };
        return messageEncryptor.messageEncryptor(message, key);
    }

    public String receiveEncryptedMessage(String message, int key) {
        DroidMessageEncryptor messageEncryptor = (msg, k) -> {
            char[] charMessage = msg.toCharArray();
            for(int i = 0; i < charMessage.length; i++) {
                char c = charMessage[i];
                if (Character.isLetter(c)) {
                    if (Character.isLowerCase(c)) {
                        charMessage[i] = (char) ('a' + (c - 'a' - k + 26) % 26);
                    } else if (Character.isUpperCase(c)) {
                        charMessage[i] = (char) ('A' + (c - 'A' - k + 26) % 26);
                    }
                }
            }
            return new String(charMessage);
        };
        return messageEncryptor.messageEncryptor(message, key);
    }



}
