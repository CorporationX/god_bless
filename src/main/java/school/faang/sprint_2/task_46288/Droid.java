package school.faang.sprint_2.task_46288;

public record Droid(String name) {

    public void sendMessage(Droid droid, String message, int key) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty or null!");
        }
        System.out.println(droid.name() + " sent an encrypted message: " + encryptMessage(message, key));
        receiveMessage(droid.name(), encryptMessage(message, key), key);
    }

    public void receiveMessage(String droidName, String encryptedMessage, int key) {
        System.out.println(droidName + " received a decrypted message: " + decryptMessage(encryptedMessage, key));
    }

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptorKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + encryptorKey) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor decryptor = (msg, encryptorKey) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append((char) ((ch - base - encryptorKey + 26) % 26 + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encrypt(encryptedMessage, key);
    }
}