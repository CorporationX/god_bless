package faang.school.godbless.modul2.droid;

import lombok.Getter;

public class Droid {
    @Getter
    private final DroidMessageReceiver receiver = new DroidMessageReceiver();
    private static final int MAX_USED_CHAR_SIZE = 26;

    public void sendEncryptedMessage(Droid targetDroid, String message, int encryptionKey) {
        var encryptor = getEncryptionMechanism();
        var encryptedMessage = encryptor.encrypt(message, encryptionKey);
        System.out.println(encryptedMessage);

        targetDroid.getReceiver().receiveEncryptedMessage(encryptedMessage, encryptionKey);
    }

    private DroidMessageEncryptor getEncryptionMechanism() {
        return (message, key) -> message.chars()
                .mapToObj(ch -> {
                    if (Character.isLetter(ch)) {
                        char base = Character.isLowerCase(ch) ? 'a' : 'A';
                        int offset = (ch - base + key) % MAX_USED_CHAR_SIZE;
                        return (char) (base + (offset < 0 ? offset + MAX_USED_CHAR_SIZE : offset));
                    } else {
                        return (char) ch;
                    }
                })
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
