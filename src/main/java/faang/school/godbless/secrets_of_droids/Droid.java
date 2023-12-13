package faang.school.godbless.secrets_of_droids;

public class Droid {

    public String sendEncryptedMessage(String message, int encryptionKey) {

        DroidMessageEncryptor df = (msg, shift) -> {
            StringBuilder s = new StringBuilder();
            int len = msg.length();
            for (int x = 0; x < len; x++) {
                char c = (char) (msg.charAt(x) + shift);
                if (c > 'z')
                    s.append((char) (msg.charAt(x) - (26 - shift)));
                else
                    s.append((char) (msg.charAt(x) + shift));
            }
            return s.toString();
        };
        return df.encryption(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMsg, int encryptionKey) {
        DroidMessageEncryptor df = (msg, shift) -> {
            StringBuilder s = new StringBuilder();
            int len = msg.length();
            for (int x = 0; x < len; x++) {
                char c = (char) (msg.charAt(x) + shift);
                if (c > 'z')
                    s.append((char) (msg.charAt(x) - (26 - shift)));
                else
                    s.append((char) (msg.charAt(x) - shift));
            }
            return s.toString();
        };

        return df.encryption(encryptedMsg, encryptionKey);
    }
}

