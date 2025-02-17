package school.faang.sprint2.task_57468;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Droid {
    private final String name;
    private final List<Character> alphabet;

    public Droid(String name) {
        validateName(name);
        this.name = name;
        alphabet = new ArrayList<>();
        initializeAlphabet();
    }

    private void initializeAlphabet() {
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabet.add(c);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }
    }

    public String encryptMessage(String message, int key) {
        validateMessage(message);
        return processMessage(message, key, true);
    }

    public String decryptMessage(String message, int key) {
        validateMessage(message);
        return processMessage(message, key, false);
    }

    private String processMessage(String message, int key, boolean isEncrypting) {
        DroidMessageEncryptor encryptor = (decryptionMessage, decryptionKey) -> {
            StringBuilder builder = new StringBuilder();
            for (char c : decryptionMessage.toCharArray()) {
                int index = alphabet.indexOf(c);
                if (index == -1) {
                    builder.append(c);
                } else {
                    int newIndex;
                    if (isEncrypting) {
                        newIndex = (index + decryptionKey) % alphabet.size();
                    } else {
                        newIndex = (index - decryptionKey + alphabet.size()) % alphabet.size();
                    }
                    char processedChar = alphabet.get(newIndex);
                    if (Character.isLowerCase(c)) {
                        builder.append(Character.toLowerCase(processedChar));
                    } else {
                        builder.append(processedChar);
                    }
                }
            }
            return builder.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public void sendMessage(String message, int key, Droid droid) {
        String messageToSend = encryptMessage(message, key);
        System.out.printf("%s sent an encrypted message: %s\n",
                getName(), messageToSend);
        receiveMessage(messageToSend, key, droid);
    }

    public void receiveMessage(String message, int key, Droid droid) {
        String messageToReceive = decryptMessage(message, key);
        System.out.printf("%s received the decrypted message: %s\n",
                droid.getName(), messageToReceive);
    }

    private void validateMessage(String message) {
        if (message == null) {
            throw new NullPointerException("Message cant be null");
        }
    }

    private void validateName(String name) {
        if (name == null) {
            throw new NullPointerException("Name cant be null");
        }
    }
}
