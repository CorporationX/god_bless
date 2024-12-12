package school.faang.droid_secrets;

import java.util.ArrayList;
import java.util.List;

public class Droid {
    private final String name;

    public Droid(String name) {
        this.name = name;
    }

    private static final List<Character> ALPHABET = new ArrayList<>(List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
    private static final DroidMessageEncryptor encryptor = (message, key) -> {
        char[] messageLetters = message.toCharArray();
        String encryptedMessage = "";

        for (Character character : messageLetters) {
            boolean isUpperCase = !character.equals(Character.toLowerCase(character));
            Character lowerChar = Character.toLowerCase(character);
            Character resultChar = character;

            if (ALPHABET.contains(lowerChar)) {
                int positionCounter = 0;
                for (Character letter : ALPHABET) {
                    if (letter.equals(lowerChar)) {
                        break;
                    }
                    positionCounter++;
                }
                int encryptPosition = positionCounter + key;
                if (ALPHABET.size() - 1 < encryptPosition) {
                    encryptPosition = encryptPosition - ALPHABET.size();
                }
                resultChar = ALPHABET.get(encryptPosition);
                if (isUpperCase) {
                    resultChar = Character.toUpperCase(resultChar);
                }
            }
            encryptedMessage = encryptedMessage.concat(resultChar.toString());
        }
        return encryptedMessage;
    };
    private static final DroidMessageEncryptor decryptor = (message, key) -> {
        char[] messageLetters = message.toCharArray();
        String encryptedMessage = "";

        for (Character character : messageLetters) {
            boolean isUpperCase = !character.equals(Character.toLowerCase(character));
            Character lowerChar = Character.toLowerCase(character);
            Character resultChar = character;

            if (ALPHABET.contains(lowerChar)) {
                int positionCounter = 0;
                for (Character letter : ALPHABET) {
                    if (letter.equals(lowerChar)) {
                        break;
                    }
                    positionCounter++;
                }
                int encryptPosition = positionCounter - key;
                if (encryptPosition < 0) {
                    encryptPosition = ALPHABET.size() + encryptPosition;
                }
                resultChar = ALPHABET.get(encryptPosition);
                if (isUpperCase) {
                    resultChar = Character.toUpperCase(resultChar);
                }
            }
            encryptedMessage = encryptedMessage.concat(resultChar.toString());
        }
        return encryptedMessage;
    };


    public String encryptMessage(String message, int key) {
        return encryptor.use(message, key);
    }
    public String decryptMessage(String message, int key) {
        return decryptor.use(message, key);
    }

    public void sendMessage(Droid recipient, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(name + " отправил зашифрованное сообщение: " + encryptedMessage);
        recipient.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String message = decryptMessage(encryptedMessage, key);
        System.out.println(name + " получил расшифрованное сообщение: " + message);
    }
}
