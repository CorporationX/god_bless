package faang.school.godbless.droids_secrets;

public class Droid {
    public static String sendEncryptedMessage(String message, int encryptionKey){
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c) && Character.isLowerCase(c)) {
                    char shifted = (char) (c + key);
                    if (shifted > 'z') {
                        shifted = (char) (shifted - 26);
                    }
                    encrypted.append(shifted);
                } else if (Character.isLetter(c) && Character.isUpperCase(c)) {
                    char shifted = (char) (c + key);
                    if (shifted > 'Z') {
                        shifted = (char) (shifted - 26);
                    }
                    encrypted.append(shifted);
                } else {
                    encrypted.append(c);
                }
            }
            return encrypted.toString();
        };
        String encryptedMessage = encryptor.encryptMessage(message, encryptionKey);
        return encryptedMessage;
    }

    public static String receiveEncryptedMessage(String encryptedMessage, int encryptionKey){
        DroidMessageEncryptor decryptor = (msg, key) -> {
            StringBuilder decrypted = new StringBuilder();
            for (char c : msg.toCharArray()){
                if (Character.isLetter(c) && Character.isLowerCase(c)){
                    char shifted = (char) (c - key);
                    if (shifted < 'a'){
                        shifted = (char) (shifted + 26);
                    }
                    decrypted.append(shifted);
                } else if (Character.isLetter(c) && Character.isUpperCase(c)){
                    char shifted = (char) (c - key);
                    if (shifted < 'A'){
                        shifted = (char) (shifted + 26);
                    }
                    decrypted.append(shifted);
                }
                else {
                    decrypted.append(c);
                }
            }
            return decrypted.toString();
        };
        String decryptedMessage = decryptor.encryptMessage(encryptedMessage, encryptionKey);
        return decryptedMessage;
    }
}
