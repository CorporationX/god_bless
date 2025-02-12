package school.faang.sprint2.task_BJS2_59799;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private static final int ALPHABET_SIZE = 26;
    private static final DroidMessageEncryptor ENCRYPTOR = (data1, key1) -> {
        StringBuilder encrypted = new StringBuilder();
        for (char c : data1.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encrypted.append((char) ((c - base + key1) % 26 + base));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    };

    private final String name;

    public void sendMessage(Droid droid, String msg, int key) {
        checkDroid(droid);
        checkKey(key);
        checkMsg(msg);
        droid.receiveMessage(encryptMessage(msg, key), key);
    }

    public void receiveMessage(String msg, int key) {
        checkMsg(msg);
        checkKey(key);
        System.out.println(decryptMessage(msg, key));
    }

    private String decryptMessage(String data, int key) {
        return ENCRYPTOR.encrypt(data, key * -1 + ALPHABET_SIZE);
    }

    private String encryptMessage(String data, int key) {
        return ENCRYPTOR.encrypt(data, key);
    }

    private void checkDroid(Droid droid) {
        if (droid == null) {
            throw new IllegalArgumentException("Дроид не может быть null");
        }
    }

    private void checkMsg(String msg) {
        if (msg == null || msg.isBlank()) {
            throw new IllegalArgumentException("Сообщение не может быть пустым или null");
        }
    }

    private void checkKey(int key) {
        if (key < 0) {
            throw new IllegalArgumentException("Ключ не может быть отрицательным");
        }
    }
}
