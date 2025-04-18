package school.faang.bjs2_70370;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class DroidService {

    public String encryptMessage(String message, int key, Function<Integer, Integer> keyTransformer) {
        int actualKey = keyTransformer.apply(key);
        DroidMessageEncryptor encryptor = (msg, encryptorKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (Character character : message.toCharArray()) {
                if (Character.isLetter(character)) {
                    char baseChar = Character.isLowerCase(character) ? 'a' : 'A';
                    encryptedMessage.append((char) ((character - baseChar + actualKey) % 26 + baseChar));
                } else {
                    encryptedMessage.append(character);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encryptMessage(message, key);
    }

    public void sendMessage(Droid senderDroid, Droid droidRecipient, String message, int key) {
        String encryptedMessage = encryptMessage(message, key, k -> k);
        log.info("Droid {} send encrypted message: {}", senderDroid.name(), encryptedMessage);
        receiveMessage(droidRecipient, encryptedMessage, key);
    }

    public void receiveMessage(Droid droidRecipient, String message, int key) {
        String decryptedMessage = encryptMessage(message, key, k -> -k + 26);
        log.info("Droid {} receive decrypted message: {}", droidRecipient.name(), decryptedMessage);
    }
}
