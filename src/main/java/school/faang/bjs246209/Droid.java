package school.faang.bjs246209;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Droid {
    @Getter
    private final String name;

    private final DroidMessageDecryptor<String, Integer, String> decryptor = (msg, key) -> {
        System.out.printf("Message: %s decrypting with algo no: %s\n", msg, key);
        return cryptWithAlgo(msg, key, false);
    };

    public Droid(String name) {
        this.name = name;
    }

    public void sendMessage(Droid droid, String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            System.out.printf("Message: %s was encrypted with algo no: %s\n", msg, key);
            return cryptWithAlgo(msg, key, true);
        };

        String encryptedMessage = encryptor.apply(message, encryptionKey);
        System.out.println("Sending message to "  + droid.getName());
        receiveMessage(droid, encryptedMessage, encryptionKey);
    }

    public void receiveMessage(Droid droid, String message, int encryptionKey) {
        String decryptedMessage = decryptor.apply(message, encryptionKey);
        System.out.println("Received message " + decryptedMessage + " by "  + droid.getName());
    }

    private String cryptWithAlgo(String message, int algo, boolean isEncrypt) {
        char[] charArray = message.toCharArray();

        List<Integer> numericList = new ArrayList<>();
        for (char c : charArray) {
            int chr = isEncrypt ? (int) c - algo : (int) c + algo;
            numericList.add(chr);
        }

        StringBuilder result = new StringBuilder();
        for (int num : numericList) {
            result.append((char) num);
        }
        return result.toString();
    }
}
