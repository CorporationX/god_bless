package faang.school.godbless.Sprint_3.DroidSecrets;

public class Droid {
    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (mess, k) -> {
            StringBuilder cifer = new StringBuilder();
            for (int i = 0; i < mess.length(); i++) {
                char oldChar = mess.charAt(i);
                char newChar = (char) ((int) oldChar + k);
                cifer.append(newChar);
            }
            return cifer.toString();
        };
        return droidMessageEncryptor.encrypt(message, key);
    }

}