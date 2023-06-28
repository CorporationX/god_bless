package faang.school.godbless.Sprint_3.DroidSecrets;

public class DroidMessageReceiver {
    public String receiveEncryptedMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (mess, k) -> {
            StringBuilder uncifer = new StringBuilder();

            for (int i = 0; i < mess.length(); i++) {
                int oldChar = mess.charAt(i);
                int newChar = oldChar - k;
                if(oldChar >=  65 && oldChar <= 90)  {
                    while (newChar < 65 || newChar > 90) {
                        newChar = 65 - newChar + 89;
                    }
                    uncifer.append((char)newChar);
                } else if (oldChar >=  97 && oldChar <= 122) {
                    while (newChar < 97 || newChar > 122) {
                        newChar = 97 - newChar + 121;
                    }
                    uncifer.append((char)newChar);
                } else uncifer.append((char)oldChar);
            }
            return uncifer.toString();
        };
        return (droidMessageEncryptor.encrypt(encryptedMessage, key));
    }
}
