package school.faang.task_57635;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;

    public String encryptMessage(String message, int key) {
        return cripto(message, key, true);
    }

    public String decryptMessage(String encryptedMessage, int key) {
        return cripto(encryptedMessage, key, false);  // Расшифровываем сообщение
    }


    private String cripto(String message, int key, boolean encrypt) {
        DroidMessageEncryptor cryptor = (msg, cryptionKey) -> {
            StringBuilder cryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    if (encrypt) {
                        cryptedMessage.append((char) ((ch - base + cryptionKey) % 26 + base));
                    } else {
                        cryptedMessage.append((char) ((ch - base - cryptionKey + 26) % 26 + base));
                    }
                } else {
                    cryptedMessage.append(ch);
                }
            }
            return cryptedMessage.toString();
        };
        return cryptor.encrypt(message, key);
    }


    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(this.name + " отправил зашифрованное сообщение: " + encryptedMessage);
        String decryptMessage = decryptMessage(encryptedMessage, key);
        System.out.println(droid.name + " получил расшифрованное сообщение: " + decryptMessage);

    }
}
