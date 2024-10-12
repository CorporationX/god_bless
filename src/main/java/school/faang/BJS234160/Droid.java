package school.faang.BJS234160;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;

    public String encryptWithCaesar(String message, int key) {
        DroidMessageEncryptor caesarEncryptor = (msg, k) -> {
            StringBuilder result = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    result.append((char) ((c - base + k) % 26 + base));
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        };
        return encryptMessage(caesarEncryptor, message, key);
    }

    public String encryptMessage(DroidMessageEncryptor droidMessageEncryptor, String message, int key) {
        return droidMessageEncryptor.Message(message, key);
    }

    public String decryptWithCaesar(String message, int key) {
        return encryptMessage(
                (msg, k) -> encryptMessage((m, l) -> m, msg, -k),
                message,
                key
        );
    }

    public String decryptMessage(DroidMessageEncryptor droidMessageEncryptor, String message, int key) {
        return droidMessageEncryptor.Message(message, key);
    }

    public void sendMessage(Droid recipient, String message, int key) {
        String encryptedMessage = encryptWithCaesar(message, key);
        recipient.receiveMessage(encryptedMessage);
    }

    public void receiveMessage(String encryptedMessage) {
        System.out.println("Received: " + encryptedMessage);
    }

    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        // Оригинальные сообщения
        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 3; // Ключ шифрования для первого сообщения
        int encryptionKey2 = 7; // Ключ шифрования для второго сообщения

        // R2D2 отправляет сообщение C3PO
        r2d2.sendMessage(c3po, message1, encryptionKey1);

        // C3PO отвечает R2D2
        c3po.sendMessage(r2d2, message2, encryptionKey2);

        // BB-8 отправляет сообщение C3PO
        bb8.sendMessage(c3po, "The mission is complete.", encryptionKey1);
    }
}
