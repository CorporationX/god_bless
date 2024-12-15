package school.faang.sprint2.task_46340;

public class Main {
    public static void main(String[] args) {
        DroidMessageEncryptor encryptor = (message, key) -> {
            String newStr = "";
            int charCode = 0;

            for (char character : message.toCharArray()) {
                if (Character.isLetter(character)) {
                    charCode = Character.toUpperCase(character);
                    charCode = (charCode - 65 + key) % 26 + 65;
                    if (Character.isUpperCase(character)) {
                        newStr += (char) charCode;
                    } else {
                        newStr += Character.toLowerCase((char) charCode);
                    }
                } else {
                    newStr += character;
                }
            }
            return newStr;
        };

        // Создаём трёх дроидов
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        // Оригинальные сообщения
        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 6; // Ключ шифрования для первого сообщения
        int encryptionKey2 = 8; // Ключ шифрования для второго сообщения

        // R2D2 отправляет сообщение C3PO
        r2d2.sendMessage(c3po, message1, encryptionKey1, encryptor);

        // C3PO отвечает R2D2
        c3po.sendMessage(r2d2, message2, encryptionKey2, encryptor);

        // BB-8 отправляет сообщение C3PO
        bb8.sendMessage(c3po, "The mission is complete.", encryptionKey1, encryptor);
    }
}
