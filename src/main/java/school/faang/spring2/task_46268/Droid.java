package school.faang.spring2.task_46268;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@AllArgsConstructor
@Getter
public class Droid {
    private String name;

    public void sendMessage(String message, int key, Droid receiver) {
        String encryptMessage = encryptMessage(message, key);
        System.out.println(name + " отправил зашифрованное сообщение: " + encryptMessage);
        System.out.println(receiver.name + " получил расшифрованное сообщение: " + receiveMessage(encryptMessage, key));
    }

    public String receiveMessage(String message, int key) {
        return decryptMessage(message, key);
    }

    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptedKey) ->
                doCipher(msg, (b) -> (char) (b + key));
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        DroidMessageEncryptor decryptor = (msg, encryptedKey) ->
                doCipher(msg, (b) -> (char) (b - key));

        return decryptor.encrypt(message, key);
    }

    private String doCipher(String msg, Function<Byte, Character> function) {
        StringBuilder builder = new StringBuilder();
        for (byte ch : msg.getBytes()) {
            builder.append(function.apply(ch));
        }
        return builder.toString();
    }


}
