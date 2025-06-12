package school.faang.secretsOfTheDroids80145;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Droid {

    private String name;

    public Droid(String name) {
        this.name = name;
    }

    public String encryptMessage(String string, int key, DroidMessageEncryptor dme) {
        return dme.encrypting(string, key);
    }

    public String decryptMessage(String str, int key, DroidMessageEncryptor dme) {
        return dme.encrypting(str, key);
    }

    public void sendMessage(Droid droid, String str, int i) {
        StringBuilder result = new StringBuilder();
        encryptMessage(str, i, (message, key) -> {
            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    int originalPos = c - base;
                    int newPos = (originalPos + key) % 26;
                    if (newPos < 0) {
                        newPos += 26;
                    }
                    char newChar = (char) (base + newPos);
                    result.append(newChar);
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        });
        System.out.printf("%s отправил зашифрованное сообщение:%s %n", droid, result);
        System.out.printf("%s получил сообщение от %s: %s %n",
                droid, this.getName(), receiveMessage(result.toString(), i));
    }

    public String receiveMessage(String str, int i) {
        StringBuilder result = new StringBuilder();
        return decryptMessage(str, i, (message, key) -> {
            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    int originalPos = c - base;
                    int newPos = (originalPos - key) % 26;
                    if (newPos < 0) {
                        newPos += 26;
                    }
                    char newChar = (char) (base + newPos);
                    result.append(newChar);
                } else {
                    result.append(c);
                }
            }

            return result.toString();
        });

    }

}
