package faang.school.godbless;

import lombok.Data;
@Data
public class Droid {
    private String message;
    private int key;

    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (sendingMessage, sendingKey) -> {
            char[] charsOfMessage = sendingMessage.toCharArray();
            StringBuilder encryptedMessage = new StringBuilder();

            for (char c : charsOfMessage) { // тут решил идти по символьно, так как если вдруг встретится последний символ, то алфавит будет начинаться снова
                int counter = key;  // буферная переменная
                char current = c;
                char lastCharacterHighRegister = 'Z'; // последний граничный символ с верхним регистром
                char firstCharacterHighRegister = 'A'; // начальный символ с верхним регистром
                char lastCharacterLowRegister = 'z';
                char firstCharacterLowRegister = 'a'; // тут просто можно будет подставить буквы, которые при которых надо будет начинать алфавит снова

                while (counter != 0) {
                    if (current == lastCharacterHighRegister) {
                        current = firstCharacterHighRegister;
                        counter--;
                    } else if (current == lastCharacterLowRegister) {
                        current = firstCharacterLowRegister;
                        counter--;
                    } else if (current == ' ') {
                        break;
                    } else {
                        current = (char) (current + 1);
                        counter--;
                    }
                }
                encryptedMessage.append(current);
            }

            return String.valueOf(encryptedMessage);
        };

        return droidMessageEncryptor.get(message, key);
    }

    public void receiveEncryptedMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (gotMessage, gotKey) -> {
            char[] charsOfEncryptedMessage = gotMessage.toCharArray();
            StringBuilder realMessage = new StringBuilder();
            char lastCharacterHighRegister = 'A';
            char firstCharacterHighRegister = 'Z';
            char lastCharacterLowRegister = 'a';
            char firstCharacterLowRegister = 'z'; // тут просто можно будет подставить буквы, которые при которых надо будет начинать алфавит снова

            for (char c : charsOfEncryptedMessage) { // тут решил идти по символьно, так как если вдруг встретится последний символ, то алфавит будет начинаться снова
                int counter = key;
                char current = c;

                while (counter != 0) {                              // по сути наверное можно было сделать, что если значение символа + key > значение Z,
                    if (current == lastCharacterHighRegister) {     // то нужно идти по символьно, а иначе просто сразу к значению символа key добавлять
                        current = firstCharacterHighRegister;
                        counter--;
                    } else if (current == lastCharacterLowRegister) {
                        current = firstCharacterLowRegister;
                        counter--;
                    } else if (current == ' ') {
                        break;
                    } else {
                        current = (char) (current - 1);
                        counter--;
                    }
                }
                realMessage.append(current);
            }

            return String.valueOf(realMessage);
        };

        String resultMessage = droidMessageEncryptor.get(encryptedMessage, key);
        this.setMessage(resultMessage); // в итоге расшифрованное сообщение ставится в поле message объекта
    }
}
