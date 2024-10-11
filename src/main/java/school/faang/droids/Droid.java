package school.faang.droids;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {

    private String name;

    private String encryptMessage(String message, Integer code){

        DroidMessageEncryptor<String> messageEncryptor = (msg, c) -> {
            StringBuilder sb = new StringBuilder();
            char[] characters = message.toCharArray();

            for (Character character : characters) {
                if (Character.isLetter(character)) {
                    char base = Character.isUpperCase(character) ? 'A' : 'a';
                    char shiftedChar = (char) ((character - base + code) % 26 + base);

                    sb.append(shiftedChar);
                } else {
                    sb.append(character);
                }
            }

            return sb.toString();
        };

        return messageEncryptor.processCode(message, code);
    }

    private String decryptMessage(String message, Integer code) {

        DroidMessageEncryptor<String> messageDecryptor = (msg, c) -> {
            StringBuilder sb = new StringBuilder();
            char[] characters = message.toCharArray();

            for (Character character : characters) {
                if (Character.isLetter(character)) {
                    char base = Character.isUpperCase(character) ? 'A' : 'a';
                    char shiftedChar = (char) ((character - base - code + 26) % 26 + base);

                    sb.append(shiftedChar);
                } else {
                    sb.append(character);
                }
            }

            return sb.toString();
        };

        return messageDecryptor.processCode(message, code);
    }

    public String sendMessage(String string, Integer code, Droid droid){
        String messageToSend = encryptMessage(string, code);
        return droid.receiveMessage(messageToSend, code);
    }

    private String receiveMessage(String string, Integer code){
        return decryptMessage(string, code);
    }
}