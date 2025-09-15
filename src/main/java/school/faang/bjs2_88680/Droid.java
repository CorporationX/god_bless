package school.faang.bjs2_88680;

public class Droid {
    public void sendMessage(String message, int key, Droid droid) {
        System.out.printf("Сообщение на отправку: %s%n", message);
        String encryptedMessage = encryptMessage(message, key, this::getEncryptedOrDecryptedString);
        System.out.printf("Зашифрованное сообщение: %s%n", encryptedMessage);
        droid.receiveMessage(encryptedMessage, key);
    }

    private void receiveMessage(String message, int key) {
        System.out.printf("Полученное сообщение: %s%n", message);
        String decryptedMessage = decryptMessage(message, key,
                (string, code) -> getEncryptedOrDecryptedString(string, -code));
        System.out.printf("Расшифрованное сообщение: %s%n", decryptedMessage);
    }

    private String encryptMessage(String message, int key, DroidMessageEncryptor encryptor) {
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key, DroidMessageEncryptor decryptor) {
        return decryptor.encrypt(message, key);
    }

    private String getEncryptedOrDecryptedString(String string, int code) {
        return string.chars()
                .map(letter -> letter + code)
                .mapToObj(letter -> String.valueOf((char) letter))
                .reduce("", String::concat);
    }
}
