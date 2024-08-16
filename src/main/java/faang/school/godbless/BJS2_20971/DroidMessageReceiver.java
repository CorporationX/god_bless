package faang.school.godbless.BJS2_20971;

import lombok.Getter;

@Getter
public class DroidMessageReceiver {
    private DroidMessageDecoder decoder = (message, encryptionKey) -> {
        StringBuilder encryptMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base - encryptionKey + 26) % 26 + base);
            }
            encryptMessage.append(c);
        }
        return encryptMessage.toString();
    };

    public void receiveEncryptedMessage(String encryptedMessage, int encryptionKey) {
        System.out.println(this.decoder.decode(encryptedMessage, encryptionKey));
    }
}
