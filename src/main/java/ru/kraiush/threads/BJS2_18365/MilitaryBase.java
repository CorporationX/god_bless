package ru.kraiush.threads.BJS2_18365;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MilitaryBase extends Thread {

    private BlockingQueue<String> inbox;
    private boolean flag;

    @Override
    public void run() {
        if (flag) {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                    inbox.put(encrypteData(getText()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            while (true) {
                try {
                    System.out.println("  <<<We've got a secret massage!>>>\n" + decrypteData(inbox.take()));
                } catch (InterruptedException e) {
                    System.out.println("The end!");
                }
            }
        }
    }

    public String encrypteData(String data) {
        String encryptedData = null;
        try {
            encryptedData = EncryptionUtils.encrypt(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return encryptedData;
    }

    public String decrypteData(String data) {
        String decryptedData = null;
        try {
            decryptedData = EncryptionUtils.decrypt(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return decryptedData;
    }

    public String getText() {
        String[] secretMessage = {"the Kladenets sword", "the invisibility cloak", "the wizard's hat", "the wand of a lifesaver", "the ring of omnipotence", "boots runners", "the vessel of eternal life", "A little luck"};
        return secretMessage[new Random().nextInt(secretMessage.length)];
    }
}
