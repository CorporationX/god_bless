package faang.school.godbless.functionalInterfaces.droids;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Droid {
    //32 - сдвиг, так как первые 31 символа служебные, а стандартные начинаются с 32го
    private static final int ENCRYPTION_OFFSET = 32;
    private String message;
    private int encryptionKey;
    private static DroidMessageEncryptor encryptor;
    private static DroidMessageEncryptor decryptor;

    public Droid(int encryptionKey) {
        this.encryptionKey = encryptionKey;

        encryptor = (message, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();

            message.chars().forEach(currentChar -> {
                int numResult = currentChar + key;

                if(numResult > 127) {  //127 - макс. значение char
                    numResult -= 127;
                    numResult += ENCRYPTION_OFFSET;
                }

                encryptedMessage.append((char) numResult);
            });

            return encryptedMessage.toString();
        };

        decryptor = (message, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();

            message.chars().forEach(currentChar -> {
                int numResult = currentChar - key;

                if(numResult < ENCRYPTION_OFFSET) {
                    numResult = 127 - ENCRYPTION_OFFSET + currentChar - key;
                }

                decryptedMessage.append((char) numResult);
            });

            return decryptedMessage.toString();
        };
    }

    public String sendEncryptedMessage(String originalMessage) throws IllegalArgumentException  {
        if(originalMessage == null || originalMessage.isBlank()) {
            throw new IllegalArgumentException("Message must be non-valued and have some information!");
        }

       return encryptor.encryptMessage(originalMessage, this.encryptionKey);
    }

    //Вопрос к ревьюеру: нужно ли каждый раз писать "throws IllegalArgumentException",
    // если в методе есть проверки, при которых он выкидывает подобное исключение?
    public String receiveEncryptedMessage(String encryptedMessage, int encryptionKey) throws IllegalArgumentException {
        if(encryptedMessage == null || encryptedMessage.isBlank()) {
            throw new IllegalArgumentException("Encrypted message must be non-valued and have some information!");
        }

        return decryptor.encryptMessage(encryptedMessage, encryptionKey);
    }
}
