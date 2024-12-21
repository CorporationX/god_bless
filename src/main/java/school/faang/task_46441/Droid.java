package school.faang.task_46441;

public class Droid {

    private String name;

    public Droid(String name) {
        this.name = name;
    }

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMsg = encryptMessage(message, key);
        System.out.println(name + " отправил зашифрованное сообщение: " + encryptedMsg);
        droid.receiveMessage(encryptedMsg, key);
    }

    private void receiveMessage(String message, int key) {
        String decryptMessage = decryptMessage(message, key);
        System.out.println(name + " получил расшифрованное сообщение: " + decryptMessage);
    }

    private String encryptMessage(String msg, int key) {
        DroidMessageEncryptor anigma = (message, shift) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + key) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return anigma.shift(msg, key);
    }

    private String decryptMessage(String msg, int key) {
        DroidMessageEncryptor alanTuring = (message, shift) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append((char) ((ch - base - key + 26) % 26 + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return alanTuring.shift(msg, key);
    }
}
