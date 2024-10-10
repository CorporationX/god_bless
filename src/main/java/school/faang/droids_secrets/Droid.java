package school.faang.droids_secrets;

import lombok.Data;

import java.util.function.BiFunction;

@Data
public class Droid {
    private final String name;
    private String message;

    public void sendMessage(String message, Integer code, Droid droid) {
        droid.setMessage(encryptMessage.encrypt(message, code));
    }

    public void receiveMessage(String message, Integer code) {
        System.out.println(decryptMessage.apply(message,code));
    }

    private DroidMessageEncryptor encryptMessage = (message, code) -> {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            // Если буква выполняем сдвиг
            if (Character.isLetter(currentChar)) {
                char base = Character.isLowerCase(currentChar) ? 'a' : 'A';
                char shiftedChar = (char) ((currentChar - base + code) % 26 + base);
                result.append(shiftedChar);
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    };

    private BiFunction<String, Integer, String> decryptMessage = (message, code) -> encryptMessage.encrypt(message, 26 - code);
}
