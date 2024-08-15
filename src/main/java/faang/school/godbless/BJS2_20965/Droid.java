package faang.school.godbless.BJS2_20965;

public class Droid {
    public static String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (string, key) -> {
            StringBuilder res = new StringBuilder();
            for (char letter : string.toCharArray()) {
                int code = letter + key % 26;
                if (Character.isLetter(letter)) {
                    res.append((char) (code <= 'z' ? code : code -  ));
                } else{
                    res.append((char) (code <= '9' ? code : code - 10));
                }
            }
            return res.toString();
        };
        return encryptor.messageEncryption(message, encryptionKey);
    }
}
