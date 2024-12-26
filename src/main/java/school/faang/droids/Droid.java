package school.faang.droids;

public class Droid {
    private final String droidName;

    public Droid(String name) {
        droidName = name;
    }

    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptKey) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char letter : msg.toCharArray()) {
                if (Character.isLetter(letter)) {
                    char base = Character.isLowerCase(letter) ? 'a' : 'A';
                    encrypted.append((char) ((letter - base + encryptKey) % 26 + base));
                } else {
                    encrypted.append(letter);
                }
            }
            return encrypted.toString();
        };
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        DroidMessageDecryptor decryptor = (msg, decryptionKey) -> {
            StringBuilder decrypted = new StringBuilder();
            for (char letter : msg.toCharArray()) {
                if (Character.isLetter(letter)) {
                    char base = Character.isLowerCase(letter) ? 'a' : 'A';
                    decrypted.append((char) ((letter - base - decryptionKey + 26) % 26 + base));
                } else {
                    decrypted.append(letter);
                }
            }
            return decrypted.toString();
        };
        return decryptor.decrypt(message, key);
    }

    public void sendMessage(Droid receiver, String message, int key) {
        String encrypted = encryptMessage(message, key);
        System.out.println(droidName + " отправил зашифрованное сообщение: " + encrypted);
        receiver.receiveMessage(encrypted, key);
    }

    public void receiveMessage(String message, int key) {
        String decrypted = decryptMessage(message, key);
        System.out.println(droidName + " получил расшифрованное сообщение: " + decrypted);
    }
}
