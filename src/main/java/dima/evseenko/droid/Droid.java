package dima.evseenko.droid;

import lombok.Data;

import javax.crypto.SecretKey;
import java.util.Objects;

@Data
public class Droid implements DroidMessageHandler {
    private String name;

    private DroidMessageHandler messageHandler;

    public Droid(String name) {
        this.name = name;
        messageHandler = this;
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
        if (Objects.nonNull(message) && Objects.nonNull(secretKey) && Objects.nonNull(from) && Objects.nonNull(messageHandler)) {
            byte[] decryptedMessage = EncryptorUtil.decryptMessage(message, secretKey);

            if (Objects.nonNull(decryptedMessage)) {
                messageHandler.handleMessage(from, new String(decryptedMessage));
            }
        }
    }

    @Override
    public void handleMessage(Droid from, String message) {
        System.out.printf("Дроид %s получил и расшифровал сообщение от %s: %s%n", this.getName(), from.getName(), message);
    }
}
