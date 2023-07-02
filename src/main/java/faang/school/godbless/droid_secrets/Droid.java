package faang.school.godbless.droid_secrets;

public class Droid {

    public String sendEncryptedMessage(String normalMessage, int encryptKey) {
        DroidMessageEncryptor droidMessageEncryptor = (message,key)-> {
          char[] charArray= message.toCharArray();
            for (int i = 0; i < message.length(); i++) {
                int num = charArray[i];
                int newNum = num+key;
                charArray[i] = (char) newNum;
            }
            StringBuilder sb = new StringBuilder();
            for (char ch: charArray) {
                sb.append(ch);
            }
            return sb.toString();
        };
        return droidMessageEncryptor.encrypt(normalMessage,encryptKey);
    }

    public String receiveEncryptedMessage(String encryptedMessage, int encryptKey){
        DroidMessageEncryptor droidMessageEncryptor = (message,key)-> {
            char[] charArray= message.toCharArray();
            for (int i = 0; i < message.length(); i++) {
                int num = charArray[i];
                int newNum = num-key;
                charArray[i] = (char) newNum;
            }
            StringBuilder sb = new StringBuilder();
            for (char ch: charArray) {
                sb.append(ch);
            }
            return sb.toString();
        };
        return droidMessageEncryptor.encrypt(encryptedMessage,encryptKey);
    }
}
