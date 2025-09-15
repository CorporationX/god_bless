package school.faang.droid;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {

    private String name;

    private final DroidMessageEncryptor encryptor = (message, key) -> {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            encrypted.append((char) (message.charAt(i) + key));
        }
        return encrypted.toString();
    };


    public void sendMessage(Droid receiver, String message, int key) {
        String encrypted = encryptor.massageEncrypt(message, key);
        System.out.println(name + " sent an encrypted message: " + encrypted);
        receiver.receiveMessage(encrypted, key, this);
    }

    public void receiveMessage(String encryptedMessage, int key, Droid sender) {
        String decrypted = encryptor.massageDecrypt(encryptedMessage, key);
        System.out.println(name + " received a decrypted message: " + decrypted);
    }
}

