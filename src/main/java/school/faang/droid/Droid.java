package school.faang.droid;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {

    private String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (m, k) -> {
            StringBuilder encrypted = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                encrypted.append((char) (message.charAt(i) + key));
            }
            return encrypted.toString();
        };
        return encryptor.massageEncrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        return encryptMessage(message, -key);
    }

    public void sendMessage(Droid receiver, String message, int key) {
        String encrypted = encryptMessage(message, key);
        System.out.println(name + " sent an encrypted message: " + encrypted);
        receiver.receiveMessage(encrypted, key, this);
    }

    public void receiveMessage(String encryptedMessage, int key, Droid sender) {
        String decrypted = decryptMessage(encryptedMessage, key);
        System.out.println(name + " received a decrypted message: " + decrypted);
    }
}

