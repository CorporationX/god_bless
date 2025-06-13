package school.faang.secretsOfTheDroids80145;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@Getter
public class Droid {
    private String name;
    static final int numberLettersAlphabet = 26;
    private static int counter = 0;
    private static final Map<Integer, InfoMessage> messageMap = new HashMap<>();
    public final DroidMessageEncryptor encryptor = ((str, key) -> {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                int originalPos = c - base;
                int newPos = (originalPos + key) % numberLettersAlphabet;
                if (newPos < 0) {
                    newPos += numberLettersAlphabet;
                }
                char newChar = (char) (base + newPos);
                result.append(newChar);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    });

    public Droid(String name) {
        this.name = name;
    }

    private final List<Integer> idMessageList = new ArrayList<>();

    public String encryptMessage(String string, int key) {
        return encryptor.encrypting(string, key);
    }

    public String decryptMessage(String str, int key) {
        key = -key;
        return encryptor.encrypting(str, key);
    }

    public void sendMessage(Droid droid, String str, int i) {

        String message = encryptMessage(str, i);
        System.out.printf("%s отправил зашифрованное сообщение для дроида -%s :%s %n",
                this.getName(), droid.getName(), message);

        messageMap.put(++counter, new InfoMessage(counter, message, i, this, droid));
        droid.idMessageList.add(counter);
    }

    public void receiveMessage() {
        if (this.idMessageList.isEmpty()) {
            System.out.printf("Сообщений для %s нет %n", this.getName());
        }
        for (Integer id : this.idMessageList) {
            InfoMessage infoMessage = messageMap.get(id);
            String descryptMessage = decryptMessage(infoMessage.getMessage(), infoMessage.getKey());
            System.out.printf("%s получил расшифрованное сообщение от дроида -%s :%s %n",
                    this.getName(), infoMessage.getRecipient().getName(), descryptMessage);
        }

    }

}
