package faang.school.godbless.droid_secrets;

public class Droid {
    static String sendEncryptedMessage(Droid droid, String message, int key) {
        DroidMessageEncryptor encryptor = ((message1, key1) -> {
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < message.length(); i++) {
                char letter = message.charAt(i);
                if(letter != ' ') {
                    if((char)(letter + key) > 'z') {
                        letter = (char)(message.charAt(i) + key - 26);
                    } else {
                        letter = (char)(message.charAt(i) + key);
                    }
                }
                builder.append(letter);
            }
            return builder.toString();
        });
        return encryptor.encrypt(message, key);
    }
}
