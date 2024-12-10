package school.faang.sprint_2.task_46223;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Droid {
    private final String name;

    public String encryptMessage(String methodMessage, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (message, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    encryptedMessage.append((char) ((c - base + encryptionKey) % 26 + base));
                } else {
                    encryptedMessage.append(c);
                }
            }
            return encryptedMessage.toString();
        };

        return droidMessageEncryptor.encrypt(methodMessage, key);
    }

    public String decryptMessage(String methodMessage, int key) {
        DroidMessageEncryptor droidMessageEncryptor = ((message, decryptionKey) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    decryptedMessage.append((char) ((c - base - decryptionKey + 26) % 26 + base));
                } else {
                    decryptedMessage.append(c);
                }
            }
            return decryptedMessage.toString();
        });

        return droidMessageEncryptor.encrypt(methodMessage, key);
    }

    public void sendMessage(Droid receiver, String message, int encryptionKey) {
        String encryptedMessage = encryptMessage(message, encryptionKey);

        System.out.println(name + "отправил зашифрованное сообщение: " + encryptedMessage);

        receiver.receiveMessage(encryptedMessage, encryptionKey);
    }

    public void receiveMessage(String message, int encryptionKey) {
        String decryptedMessage = decryptMessage(message, encryptionKey);

        System.out.println(name + "получил и расшифровал сообщение: " + decryptedMessage);
    }
}
