package faang.school.godbless;

public class Droid {
    public static void main(String[] args) {
        String message = "Try to understand";
        int encryptionKey = 1;

        System.out.println("The original message: " + message);
        String encryptedMessage = sendEncryptedMessage(message, encryptionKey);
        System.out.println("The encrypted message: " + encryptedMessage);
        System.out.println("The received message: " + receiveEncryptedMessage(encryptedMessage, encryptionKey));
    }

    static String sendEncryptedMessage(String message, int key){
        DroidMessageEncryptor encryptor = ((message1, key1) -> {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                char letter = message.charAt(i);
                if(letter != ' '){
                    if (letter + key > 'z'){
                        letter = (char)(message.charAt(i) + key - 26);
                    } else {
                        letter = (char) (message.charAt(i) + key);
                    }
                }
                builder.append(letter);
            }
            return builder.toString();
        });
        return encryptor.messageEncrypt(message, key);
    }

    static String receiveEncryptedMessage(String message, int key){
        DroidMessageEncryptor receiver = ((message1, key1) -> {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                char letter = message.charAt(i);
                if (letter != ' '){
                    if(letter + key < 'A'){
                        letter = (char) (message.charAt(i) - key +26);
                    } else {
                        letter = (char) (message.charAt(i) - key);
                    }
                }
                builder.append(letter);
            }
            return builder.toString();
        });
        return receiver.messageEncrypt(message, key);
    }
}
