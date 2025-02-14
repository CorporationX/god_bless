package BJS257432;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Droid {
    private String name;

    public void sendMessage(String message, int key, Droid droid) {

        String encryptedMessage = encryptMessage(message, key);
        log.info(name +  " for " + droid.getName());
        System.out.println(" Send encrypt message: " + encryptedMessage);
        log.info(droid.getName() + " from " + name);
        System.out.println(" get decrypt message: " + droid.receiveMessage(encryptedMessage, key));
    }

    public String receiveMessage(String encryptedMessage, int key) {
        return decryptMessage(encryptedMessage, key);
    }

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msgForEncrypt, encryptKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : msgForEncrypt.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isUpperCase(ch) ? 'A' : 'a';
                    encryptedMessage.append((char) ((ch - base + encryptKey + 26) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encryptDecrypt(message, key);
    }

    public String decryptMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor decryptor = (msgForDecrypt, decryptKey) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : msgForDecrypt.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isUpperCase(ch) ? 'A' : 'a';
                    decryptedMessage.append((char) ((ch - base - decryptKey + 26) % 26 + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encryptDecrypt(encryptedMessage, key);
    }


}
