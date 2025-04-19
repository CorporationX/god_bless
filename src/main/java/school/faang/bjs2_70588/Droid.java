package school.faang.bjs2_70588;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@RequiredArgsConstructor
@Slf4j
public class Droid {
    private static final String BASIC_ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String KEY_ALPHABET = BASIC_ALPHABET + BASIC_ALPHABET.toLowerCase();
    private static final int LENGH_OF_ALPHABET = KEY_ALPHABET.length();

    private final String name;

    DroidMessageEncryptor messageEncryptor = (message, key) -> {
        StringBuilder result = new StringBuilder();
        int shift = ((key % LENGH_OF_ALPHABET) + LENGH_OF_ALPHABET) % LENGH_OF_ALPHABET;
        int indexOfChar = 0;

        for (char ch : message.toCharArray()) {
            indexOfChar = KEY_ALPHABET.indexOf(ch);
            if (indexOfChar != -1) {
                int newIndex = (indexOfChar + shift) % LENGH_OF_ALPHABET;
                result.append(KEY_ALPHABET.charAt(newIndex));
                continue;
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    };

    public String encryptMessage(String message, int encryptionKey) {
        return messageEncryptor.encrypt(message, encryptionKey);
    }

    public String decryptMessage(String message, int encryptionKey) {
        return messageEncryptor.encrypt(message, -encryptionKey);
    }

    public void sendMessage(Droid droidReceiver, String message, int encryptionKey) {
        String encryptedMessage = encryptMessage(message, encryptionKey);
        log.info("Сообщение {} было отправлено дроиду {}.", encryptedMessage, droidReceiver.getName());
        droidReceiver.receiveMessage(encryptedMessage, encryptionKey);
    }

    public void receiveMessage(String message, int encryptionKey) {
        String decryptedMessage = decryptMessage(message, encryptionKey);
        log.info("Сообщение {} было получено дроидом {}.", decryptedMessage, getName());
    }
}
