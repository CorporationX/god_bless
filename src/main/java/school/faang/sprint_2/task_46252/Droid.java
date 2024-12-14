package school.faang.sprint_2.task_46252;

public class Droid {
    private final String name;

    public Droid(String name) {
        this.name = name;
    }

    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (_message, _key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : _message.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + _key) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        DroidMessageEncryptor decryptor = (_message, _key) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : _message.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append((char) ((ch - base - _key + 26) % 26 + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encrypt(message, key);
    }

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(name + " отправил сообщение: " + encryptedMessage);
        droid.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.println(name + " получил сообщение: " + decryptedMessage);
    }
}
