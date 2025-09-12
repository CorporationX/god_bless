package school.faang.bjs2_87446;

public class Droid {
    private String name;

    public Droid(String name) {
        this.name = name;
    }

    public void sendMessage(Droid droid, String message, int key) {
        if (droid == null || message == null) {
            return;
        }
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(name + " отправил зашифрованное сообщение: " + encryptedMessage);
        receiveMessage(encryptedMessage, key);
    }

    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder encrypted = new StringBuilder();
            msg.chars()
                    .mapToObj(c -> (char) c)
                    .forEach(c -> {
                        if (Character.isLetter(c)) {
                            char base = Character.isLowerCase(c) ? 'a' : 'A';
                            int shifted = (c - base + k) % 26;
                            if (shifted < 0) {
                                shifted += 26;
                            }
                            encrypted.append((char) (base + shifted));
                        } else {
                            encrypted.append(c);
                        }
                    });
            return encrypted.toString();
        };
        return encryptor.process(message, key);
    }

    private void receiveMessage(String message, int key) {
        String decryptMessage = decryptMessage(message, key);
        System.out.println(name + " получил расшифрованное сообщение: " + decryptMessage);
    }

    private String decryptMessage(String message, int key) {
        return encryptMessage(message, -key);
    }
}
