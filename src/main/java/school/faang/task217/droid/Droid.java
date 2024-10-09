package school.faang.task217.droid;

import lombok.AllArgsConstructor;
import lombok.Getter;
import school.faang.task217.functional.DroidMessageEncryptor;

@AllArgsConstructor
public class Droid {
    @Getter
    private String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptMessage = (String, intKey) -> {
            char[] arrayOfLetters = message.toCharArray();
            for (int i = 0; i < arrayOfLetters.length; i++) {
                if (Character.isLetter(arrayOfLetters[i])) {
                    char base = Character.isLowerCase(arrayOfLetters[i]) ? 'a' : 'A';
                    int a = (arrayOfLetters[i] - base + key) % 26;
                    arrayOfLetters[i] = (char) ((arrayOfLetters[i] - base + key) % 26 + base);
                }
            }
            return String.valueOf(arrayOfLetters);
        };
        return encryptMessage.cipher(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor decryptMessage = (String, intKey) -> {
            char[] arrayOfLetters = message.toCharArray();
            for (int i = 0; i < arrayOfLetters.length; i++) {
                if (Character.isLetter(arrayOfLetters[i])) {
                    char base = Character.isLowerCase(arrayOfLetters[i]) ? 'a' : 'A';
                    arrayOfLetters[i] = (char) ((arrayOfLetters[i] - base - key + 26) % 26 + base);
                }
            }
            return String.valueOf(arrayOfLetters);
        };
        return decryptMessage.cipher(message, key);
    }

    public void sendMessage(String message, int key, Droid droid) {
        message = encryptMessage(message, key);
        System.out.println(this.getName() + " отправил зашифрованное сообщение: " + message);
        droid.receiveMessage(message, key);
    }

    public void receiveMessage(String message, int key) {
        System.out.println(this.getName() + " получил расшифрованное сообщение: " + decryptMessage(message, key));
    }
}
