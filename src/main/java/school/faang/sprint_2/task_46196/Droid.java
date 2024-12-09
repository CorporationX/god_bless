package school.faang.sprint_2.task_46196;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.function.Function;

@AllArgsConstructor
@Getter
public class Droid {
    private String name;

    private String encryptMessage(@NonNull String message, int key) {
        keyValidate(key);
        DroidMessageEncryptor encryptor =
                (msg, keyForEncryption) -> processCipher(msg, (charByte) -> (char) (charByte + keyForEncryption));
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(@NonNull String message, int key) {
        keyValidate(key);
        DroidMessageEncryptor decrypt =
                (msg, keyForEncryption) -> processCipher(msg, (charByte) -> (char) (charByte - keyForEncryption));
        return decrypt.encrypt(message, key);
    }

    private String processCipher(@NonNull String msg, @NonNull Function<Byte, Character> cipherAction) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte charByte : msg.getBytes()) {
            stringBuilder.append(cipherAction.apply(charByte));
        }
        return stringBuilder.toString();
    }

    public void sendMessage(@NonNull String message, int key, @NonNull Droid recipientDroid) {
        keyValidate(key);
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(name + " отправил зашифрованное сообщение: " + message);
        recipientDroid.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(@NonNull String message, int key) {
        keyValidate(key);
        String decryptedMessage = decryptMessage(message, key);
        System.out.println(name + " получил расшифрованное сообщение: " + decryptedMessage);
    }

    private void keyValidate(int key) {
        if (key <= 0) {
            throw new IllegalArgumentException("Key must greater than 0");
        }
    }
}
