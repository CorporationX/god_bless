package faang.school.godbless.functionalInterfaces.droids;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Droid {
    private String message;
    private int encryptionKey;

    public Droid(int encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public String sendEncryptedMessage(String originalMessage) throws IllegalArgumentException  {
        if(originalMessage == null || originalMessage.isBlank()) {
            throw new IllegalArgumentException("Message must be non-valued and have some information!");
        }

        DroidMessageEncryptor encryptor = (message, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();

            message.chars().forEach(currentChar -> {
                        int numResult = currentChar + key;

                        if(numResult > 127) {
                            numResult -= 127;
                            numResult += 32;
                        }

                        char result = (char) (numResult);
                        encryptedMessage.append(result);
                    });

            return encryptedMessage.toString();
        };

       return encryptor.encryptMessage(originalMessage, this.encryptionKey);
    }

    //Вопрос к ревьюеру: нужно ли каждый раз писать "throws IllegalArgumentException",
    // если в методе есть проверки, при которых он выкидывает подобное исключение?
    public String receiveEncryptedMessage(String encryptedMessage, int encryptionKey) throws IllegalArgumentException {
        if(encryptedMessage == null || encryptedMessage.isBlank()) {
            throw new IllegalArgumentException("Encrypted message must be non-valued and have some information!");
        }

        DroidMessageEncryptor decryptor = (message, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();

            message.chars().forEach(currentChar -> {
                int numResult = currentChar - key;

                if(numResult < 32) {
                    numResult = 127 - 32 + currentChar - key;
                }

                char result = (char) (numResult);
                decryptedMessage.append(result);
            });

            return decryptedMessage.toString();
        };

        return decryptor.encryptMessage(encryptedMessage, encryptionKey);
    }
}
