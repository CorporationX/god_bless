package faang.school.godbless.droids;

import java.util.Arrays;

public class Droid {
    DroidMessageReceiver receiver = new DroidMessageReceiver();

    public DroidMessageReceiver getReceiver() {
        return receiver;
    }

    public void sendEncryptedMessage(Droid droidGetter, String message, int crypt){
        DroidMessageEncryptor messageEncryptor = (messageForSend, cryptForMessage) -> {
             char[] charsOfMes = messageForSend.toCharArray();
            for (int i = 0; i < charsOfMes.length; i++) {
                charsOfMes[i] = charsOfMes[i] == 122 ? (char) 97 : (char) (charsOfMes[i] + crypt);
            }
             return String.valueOf(charsOfMes);
        };
        System.out.println(messageEncryptor.encrypt(message, crypt));
        System.out.println("Сообщение зашивровано и отправлено");
        droidGetter.getReceiver().receiveEncryptedMessage(messageEncryptor.encrypt(message, crypt), crypt);
    }
}
