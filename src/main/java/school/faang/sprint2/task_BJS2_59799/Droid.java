package school.faang.sprint2.task_BJS2_59799;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private final String name;

    public void sendMessage(Droid droid, String data, int key) {
        droid.receiveMessage(encryptMessage(data, key), key);
    }

    public void receiveMessage(String data, int key) {
        System.out.println(decryptMessage(data, key));
    }

    private String decryptMessage(String data, int key) {
        return encryptMessage(data, key * -1 + 26);
    }

    private String encryptMessage(String data, int key) {
        DroidMessageEncryptor encryptor = (data1, key1) -> {
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

        return encryptor.encrypt(data, key);
    }
}
