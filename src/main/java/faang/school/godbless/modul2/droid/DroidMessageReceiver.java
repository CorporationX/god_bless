package faang.school.godbless.modul2.droid;

public class DroidMessageReceiver {
    private static final int MAX_USED_CHAR_SIZE = 26;

    public void receiveEncryptedMessage(String encryptedMessage, int key) {
        var decryptor = getDecryptionMechanism();
        var decryptedMessage = decryptor.decrypt(encryptedMessage, key);
        System.out.println(decryptedMessage);
    }

    private DroidMessageDecryptor getDecryptionMechanism() {
        return (message, key) -> message.chars()
                .mapToObj(ch -> {
                    if (Character.isLetter(ch)) {
                        char base = Character.isLowerCase(ch) ? 'a' : 'A';
                        int offset = (ch - base - key) % MAX_USED_CHAR_SIZE;
                        return (char) (base + (offset < 0 ? offset + MAX_USED_CHAR_SIZE : offset));
                    } else {
                        return (char) ch;
                    }
                })
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}

