package school.faang.task_46328;

import lombok.Data;

@Data
public class Droid {
    String name;

    public Droid(String name) {
        this.name = name;
    }

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (messageString, keyEncryptor) -> {
            StringBuilder messageEncryptor = new StringBuilder();
            for (char ch : messageString.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    messageEncryptor.append((char) ((ch - base + keyEncryptor) % 26 + base));
                } else {
                    messageEncryptor.append(ch);
                }
            }
            return messageEncryptor.toString();
        };
        return encryptor.code(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (messageString, keyEncryptor) -> {
            StringBuilder messageEncryptor = new StringBuilder();
            for (char ch : messageString.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    messageEncryptor.append((char) ((ch - base - keyEncryptor) % 26 + base));
                } else {
                    messageEncryptor.append(ch);
                }
            }
            return messageEncryptor.toString();
        };
        return encryptor.code(message, key);
    }

    public void sendMessage(String message, int key, Droid droidRecipient) {
        String messageForRecipient = encryptMessage(message, key);
        System.out.println("Сообщение " + messageForRecipient + " отправлено Дроиду " + droidRecipient.getName());
        receiveMessage(messageForRecipient, key);
    }

    public void receiveMessage(String message, int key) {
        System.out.println("Получено расшифрованное сообщение: " + decryptMessage(message, key));
    }
}
