package faang.school.godbless;

import lombok.val;

public class Droid {
    public void sendEncryptedMessage(Droid droid,String message, Integer key){
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char c : msg.toCharArray()) {
                // Проверяем, является ли символ буквой
                if (Character.isLetter(c)) {
                    // Определяем базовый символ ('A' или 'a')
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    // Смещаем символ и корректируем в пределах алфавита
                    char shifted = (char) ((c - base + k) % 26 + base);
                    encrypted.append(shifted);
                } else {
                    // Если символ не является буквой, добавляем его без изменений
                    encrypted.append(c);
                }
            }
            return encrypted.toString();
        };

        // Используем шифровщик для шифрования сообщения
        String encryptedMessage = encryptor.encrypt(message, key);

        // Для демонстрации выводим зашифрованное сообщение
        System.out.println("Encrypted Message: " + encryptedMessage);
        droid.receiveEncryptedMessage(encryptedMessage,key);

    }

    public void receiveEncryptedMessage(String encryptedMessage, Integer key){
        DroidMessageReceiver decryptor = (msg, k) -> {
            StringBuilder decrypted = new StringBuilder();
            for (char c : msg.toCharArray()) {
                // Проверяем, является ли символ буквой
                if (Character.isLetter(c)) {
                    // Определяем базовый символ ('A' или 'a')
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    // Смещаем символ в обратную сторону и корректируем в пределах алфавита
                    char shifted = (char) ((c - base - k + 26) % 26 + base);
                    decrypted.append(shifted);
                } else {
                    // Если символ не является буквой, добавляем его без изменений
                    decrypted.append(c);
                }
            }
            return decrypted.toString();
        };

        // Используем дешифровщик для расшифровки сообщения
        String decryptedMessage = decryptor.decryptMessage(encryptedMessage, key);

        // Для демонстрации выводим расшифрованное сообщение
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
