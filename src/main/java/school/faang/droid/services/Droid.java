package school.faang.droid.services;

import lombok.Data;

@Data
public class Droid {
    private String name;

    public Droid(String name) {
        this.name = name;
    }

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptorKey) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    stringBuilder.append((char) ((ch - base + encryptorKey) % 26 + base));
                } else {
                    stringBuilder.append(ch);
                }
            }
            return stringBuilder.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String message, Integer key) {
        DroidMessageEncryptor encryptor = (msg, encryptorKey) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    stringBuilder.append((char) ((ch - base - encryptorKey + 52) % 26 + base));
                } else {
                    stringBuilder.append(ch);
                }
            }
            return stringBuilder.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public void sendMessage(Droid droid, String message, int key){
        message = encryptMessage(message, key);
        System.out.println(name + " отправил зашифрованное сообщение: " + message);
        droid.receiveMessage(message, key);

    }

    public void receiveMessage(String message, int key){
        message = decryptMessage(message, key);
        System.out.println(name + " получил расшифрованное сообщение: " + message);
    }
}

