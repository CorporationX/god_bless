package school.BJS2_34118;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {

    private final Integer ALPHABET_SIZE = 26;

    private String name;

    public String encryptMessage(String line, int number) {
        DroidMessageEncryptor droidMessage = (message, count) -> caesarCipher(message, count);
        return droidMessage.method(line, number);
    }

    public String decryptMessage(String line, int number) {
        DroidMessageEncryptor droidMessage = (message, count) -> decrypt(message, count);
        return droidMessage.method(line, number);
    }

    public void sendMessage(Droid droid, String text, int number) {
        String shifr = encryptMessage(text, number);
        System.out.println(name + " отправил зашифрованное сообщение: " + shifr);
        String normText = droid.receiveMessage(shifr, number);
        System.out.println(droid.getName() + " получил расшифрованное сообщение: " + normText);

    }

    private String receiveMessage(String text, int number) {
        String normText = decryptMessage(text, number);
        return normText;
    }

    private String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char encrypted = (char) (c + shift);
                if ((Character.isLowerCase(c) && encrypted > 'z') || (Character.isUpperCase(c) && encrypted > 'Z')) {
                    result.append((char) (c - (ALPHABET_SIZE - shift)));
                } else {
                    result.append(encrypted);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public String decrypt(String text, int shift) {
        return caesarCipher(text, ALPHABET_SIZE - shift);
    }


}