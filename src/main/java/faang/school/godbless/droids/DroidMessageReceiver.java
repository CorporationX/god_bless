package faang.school.godbless.droids;

import java.util.Arrays;

public class DroidMessageReceiver {
    public void receiveEncryptedMessage(String cryptedMessage, int crypt){
        DroidMessageEncryptor messageEncryptor = (message, cryptForMes) ->{
          char[] charsOfMes = message.toCharArray();
            for (int i = 0; i < charsOfMes.length; i++) {
                charsOfMes[i] = charsOfMes[i] == (char)97 ? (char) (122) : (char)(charsOfMes[i] - crypt);
            }
            return String.valueOf(charsOfMes);
        };
        System.out.println(messageEncryptor.encrypt(cryptedMessage, crypt));
    }
}
