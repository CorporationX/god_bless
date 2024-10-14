package dima.evseenko.droid;

import lombok.Data;

import javax.crypto.SecretKey;
import java.util.Objects;
import java.util.function.BiConsumer;

@Data
public class Droid {
    private String name;

    private DroidMessageHandler messageHandler;

    public Droid(String name) {
        this.name = name;
    }

    public void sendMessage(Droid to, String message, SecretKey secretKey) {
        if (Objects.nonNull(to) && Objects.nonNull(secretKey) && Objects.nonNull(message)) {
            byte[] encryptedMessage = EncryptorUtil.encryptMessage(message.getBytes(), secretKey);

            if (Objects.nonNull(encryptedMessage)) {
                System.out.printf("Дроид %s отправил зашифрованное сообщение %s: %s%n", this.getName(), to.getName(), new String(encryptedMessage));
                to.receiveMessage(this, encryptedMessage, secretKey);
            }
        }
    }

    private void receiveMessage(Droid from, byte[] message, SecretKey secretKey) {
        if (Objects.nonNull(message) && Objects.nonNull(secretKey) && Objects.nonNull(from)) {
            byte[] decryptedMessage = EncryptorUtil.decryptMessage(message, secretKey);

            if (Objects.nonNull(decryptedMessage) && Objects.nonNull(messageHandler)) {
                messageHandler.handleMessage(from, this, new String(decryptedMessage));
            }
        }
    }
}
