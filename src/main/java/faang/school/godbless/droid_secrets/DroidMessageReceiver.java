package faang.school.godbless.droid_secrets;

public class DroidMessageReceiver {
    public static void receiveEncryptedMessage (String message, int key) {
        DroidMessageEncryptor encryptor = ((message1, key1) -> {
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < message.length(); i++) {
                char letter = message.charAt(i);
                if(letter != ' ') {
                    if((char)(letter - key) < 'a') {
                        letter = (char)(message.charAt(i) + 26 - key);
                    } else {
                        letter = (char)(message.charAt(i) - key);
                    }
                }
                builder.append(letter);
            }
            return builder.toString();
        });
        System.out.println(encryptor.encrypt(message, key));
    }
}
