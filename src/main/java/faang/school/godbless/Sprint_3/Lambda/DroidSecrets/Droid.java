package faang.school.godbless.Sprint_3.Lambda.DroidSecrets;

public class Droid {
    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (mess, k) -> {
            StringBuilder cifer = new StringBuilder();
            for (int i = 0; i < mess.length(); i++) {
                int oldChar = mess.charAt(i);
                int newChar = oldChar + k;
                if(oldChar >=  65 && oldChar <= 90)  {
                    while (newChar > 90) {
                        newChar = newChar - 90 + 64;
                    }
                    cifer.append((char)newChar);
                } else if (oldChar >=  97 && oldChar <= 122) {
                    while (newChar > 122) {
                        newChar = newChar - 122 + 96;
                    }
                    cifer.append((char)newChar);
                } else cifer.append((char)oldChar);
            }
            return cifer.toString();
        };
        return droidMessageEncryptor.encrypt(message, key);
    }

}