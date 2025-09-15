package school.faang.bjs2_88888;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Droid {
    private static final int ALPHABET_LENGTH = 26;
    @Getter
    private String name;

    //Поставить потом private
    private String encryptMessage(String message, int key) {
        if (message == null) {
            throw new IllegalArgumentException("Message not be null");
        }
        DroidMessageEncryptor cryptMessage = ((words, keys) -> {
            String crypt = "";
            for (int i = 0; i < words.length(); i++) {
                if (Character.isLetter(words.charAt(i))) {
                    char base = Character.isLowerCase(words.charAt(i)) ? 'a' : 'A';
                    char encryptChar = (char) ((words.charAt(i) - base + keys) % ALPHABET_LENGTH + base);
                    crypt += encryptChar;
                } else {
                    crypt += words.charAt(i);
                }
            }
            return crypt;
        });
        return cryptMessage.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        if (message == null) {
            throw new IllegalArgumentException("Message not be null");
        }
        DroidMessageEncryptor decrypt = ((words, keys) -> {
            String decryptMessage = "";
            for (int i = 0; i < words.length(); i++) {
                if (Character.isLetter(words.charAt(i))) {
                    char base = Character.isLowerCase(words.charAt(i)) ? 'a' : 'A';
                    char encryptChar =
                            (char) ((words.charAt(i) - base - keys + ALPHABET_LENGTH) % ALPHABET_LENGTH + base);
                    decryptMessage += encryptChar;
                } else {
                    decryptMessage += words.charAt(i);
                }
            }
            return decryptMessage;
        });
        return decrypt.encrypt(message, key);
    }

    public void sendMessage(Droid droid, String message, int key) {
        String encryptMessage = encryptMessage(message, key);
        log.info("{} - Зашифровал сообщение : {}\n", this.name, encryptMessage);
        receiveMessage(droid, encryptMessage, key);
    }

    public void receiveMessage(Droid droid, String message, int key) {
        String decrypt = decryptMessage(message, key);
        log.info("{} - Расшифровал сообщение : {}\n", droid.getName(), decrypt);
    }
}
