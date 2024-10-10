package school.faang.sprint_2.secretOfDroid;

public record Droid(String name) {
    public Droid {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Droid не может быть без имени");
        }
    }

    public void sendMessage(String message, int key, Droid droid) {
        String encryptedMassage = encryptMessage(message, key);
        System.out.println(this.name + " отправил зашифрованное сообщение: " + encryptedMassage);
        String decryptedMessage = receiveMessage(encryptedMassage, key);
        System.out.println(droid.name + " получил расшифрованное сообщение: " + decryptedMessage);
    }

    public String receiveMessage(String encryptedMessage, int key) {
        return decryptMessage(encryptedMessage, key);
    }

    public static String encryptMessage(String message, int key) {
        DroidMessageEncryptor<String, Integer> encryptor = (msg, encryptionKey) -> {
            StringBuilder encryptedMassage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMassage.append((char) ((ch - base + encryptionKey) % 26 + base));
                } else {
                    encryptedMassage.append(ch);
                }
            }
            return encryptedMassage.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor<String, Integer> decryptor = (msg, encryptionKey) -> {
            StringBuilder decryptedMassage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMassage.append((char) ((ch - base - encryptionKey + 26) % 26 + base));
                } else {
                    decryptedMassage.append(ch);
                }
            }
            return decryptedMassage.toString();
        };
        return decryptor.encrypt(message, key);
    }
}
