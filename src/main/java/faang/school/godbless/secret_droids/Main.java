package faang.school.godbless.secret_droids;

public class Main {
    public static void main(String[] args) {
        Droid d2r2 = new Droid();
        Droid c3po = new Droid();

        String message = "May the Force be with you!";
        int key = 3;

        String encryptedMessageSending = d2r2.sendEncryptedMessage(message, key);
        String incomingEncryptedMessage = c3po.receiveEncryptedMessage(encryptedMessageSending, key);
        System.out.println("мы отправляем сообщение: " + message + " Применяем кодировку -> " + encryptedMessageSending);
        System.out.println("мы получаем зашифрованное сообщение: " + encryptedMessageSending + " Применяем раскодировку -> " + incomingEncryptedMessage);
    }
}


class Droid {
    public String sendEncryptedMessage(String message, int password) {
        DroidMessageEncryptor secretCode = (text, key) -> {
            StringBuilder secretingBuilder = new StringBuilder();
            for (char symbol : text.toCharArray()) {
                secretingBuilder.append((char) (symbol + key));
            }
            return secretingBuilder.toString();
        };
        return secretCode.encrypting(message, password);
    }

    public String receiveEncryptedMessage(String message, int password) {
        DroidMessageEncryptor decodingMessage = (text, key) -> {
            StringBuilder decodingBuilder = new StringBuilder();
            for (char symbol : text.toCharArray()) {
                decodingBuilder.append((char) (symbol - key));
            }
            return decodingBuilder.toString();
        };
        return decodingMessage.encrypting(message, password);
    }
}