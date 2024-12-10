package school.faang.sprint_2.task_46215;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Droid {
    private String name;
    private String message;
    private int encryptionKey;
    private final DroidMessageManager messageManager = new DroidMessageManager();

    public Droid(String name, int encryptionKey) {
        this.name = name;
        this.message = "";
        this.encryptionKey = encryptionKey;
    }

    public void sendMessage(@NonNull Droid droid, @NonNull String message) {
        this.message = messageManager.encryptMessage(message, this.encryptionKey);
        System.out.printf("%s направил зашифрованное сообщение для %s: %s\n",
                this.name, droid.getName(), this.message);
    }

    public void receiveMessage(@NonNull Droid droid) {
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
