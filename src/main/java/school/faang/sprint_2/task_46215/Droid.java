package school.faang.sprint_2.task_46215;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Droid {
    String name;
    String message;
    int encryptionKey;
    DroidMessageManager messageManager = new DroidMessageManager();

    public Droid(String name, int encryptionKey) {
        this.name = name;
        this.message = "";
        this.encryptionKey = encryptionKey;
    }

    public void sendMessage(Droid droid, String message) {
        this.message = messageManager.encryptMessage(message, this.encryptionKey);
        System.out.printf("%s направил зашифрованное сообщение для %s: %s\n",
                this.name, droid.getName(), this.message);
    }

    public void receiveMessage(Droid droid) {
        if (droid.getMessage().isEmpty()) {
            System.out.printf("%s пытается получить сообщение от %s, но %s не передавал сообщение\n",
                    this.name, droid.getName(), droid.getName());
        } else {
            String message = droid.getMessage();
            String decryptionMessage = messageManager.decryptMessage(message, droid.getEncryptionKey());
            System.out.printf("%s получил расшифрованное сообщение от %s: %s\n",
                    this.name, droid.getName(), decryptionMessage);
        }
    }
}
