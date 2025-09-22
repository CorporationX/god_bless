package bjs2_90799;

public class Droid {
    private final String name;

    private static final String LOWER_LATIN = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_LATIN = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CYR   = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String UPPER_CYR   = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    private static final DroidMessageEncryptor ENCRYPTOR = (message, key) -> {
        StringBuilder sb = new StringBuilder(message.length());
        for (char ch : message.toCharArray()) {
            sb.append(shiftChar(ch, key));
        }
        return sb.toString();
    };

    public Droid(String name) {
        this.name = name;
    }

    private static char shiftChar(char ch, int key) {
        int idx;
        int n;
        int k;

        idx = LOWER_LATIN.indexOf(ch);
        if (idx >= 0) {
            n = LOWER_LATIN.length();
            k = Math.floorMod(key, n);
            return LOWER_LATIN.charAt((idx + k) % n);
        }

        idx = UPPER_LATIN.indexOf(ch);
        if (idx >= 0) {
            n = UPPER_LATIN.length();
            k = Math.floorMod(key, n);
            return UPPER_LATIN.charAt((idx + k) % n);
        }

        idx = LOWER_CYR.indexOf(ch);
        if (idx >= 0) {
            n = LOWER_CYR.length();
            k = Math.floorMod(key, n);
            return LOWER_CYR.charAt((idx + k) % n);
        }

        idx = UPPER_CYR.indexOf(ch);
        if (idx >= 0) {
            n = UPPER_CYR.length();
            k = Math.floorMod(key, n);
            return UPPER_CYR.charAt((idx + k) % n);
        }

        return ch;
    }

    public String encryptMessage(String message, int key) {
        return ENCRYPTOR.encrypt(message, key);
    }

    public String decryptMessage(String encryptedMessage, int key) {
        return ENCRYPTOR.encrypt(encryptedMessage, -key);
    }

    public void sendMessage(Droid receiver, String message, int key) {
        String encrypted = encryptMessage(message, key);
        System.out.println(name + " отправил зашифрованное сообщение: " + encrypted);
        receiver.receiveMessage(encrypted, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decrypted = decryptMessage(encryptedMessage, key);
        System.out.println(name + " получил расшифрованное сообщение: " + decrypted);
    }
}