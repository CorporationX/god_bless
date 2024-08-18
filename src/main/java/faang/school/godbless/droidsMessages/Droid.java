package faang.school.godbless.droidsMessages;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Droid {
    private int id;
    private Map<String, Integer> receivedEncryptedMessages;

    public Droid(int id){
        this.id = id;
        this.receivedEncryptedMessages = new HashMap<>();
    }

    public void sendEncryptedMessage(Droid droid, String message, int key){
        DroidMessageEncryptor droidMessageEncryptor = (m, k) -> CaesarCipher.code(m, k);
        String encryptedMessage = droidMessageEncryptor.encryptMessage(message, key);
        droid.getReceivedEncryptedMessages().put(encryptedMessage, key);
    }
}
