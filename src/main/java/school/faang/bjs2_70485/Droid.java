package school.faang.bjs2_70485;

import lombok.Data;

@Data
public class Droid {
    private final String name;

    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (m, k) -> {
            char[] chars = m.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) (chars[i] + k);
            }
            return new String(chars);
        };

        return encryptor.get(message, key);
    }

    private String decryptMessage(String message, int key) {
        return encryptMessage(message, key * -1);
    }

    public void sendMessage(Droid droid, String message, int key) {
        String encryptMessage = encryptMessage(message, key);
        System.out.printf("%s отправил зашифрованное сообщение: %s%n", this.name, encryptMessage);
        droid.receiveMessage(encryptMessage(message, key), key);
    }

    public void receiveMessage(String message, int key) {
        String decryptMessage = decryptMessage(message, key);
        System.out.printf("%s получил расшифрованное сообщение: %s%n", this.name, decryptMessage);
    }


}
