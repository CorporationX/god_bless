package school.faang.droid.secrets;

public class Main {
    public static void main(String[] args) {
        DroidMessageEncryptor encryptor = (message, key) -> processMessage(message, key);
        DroidMessageEncryptor decryptor = (message, key) -> processMessage(message, 26 - key);

        Droid r2d2 = new Droid("R2D2", encryptor, decryptor);
        Droid c3po = new Droid("C3PO", encryptor, decryptor);
        Droid bb8 = new Droid("BB-8", encryptor, decryptor);

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        String message3 = "The mission is complete.";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        r2d2.sendMessage(message1, encryptionKey1, c3po);
        c3po.sendMessage(message2, encryptionKey2, r2d2);
        bb8.sendMessage(message3, encryptionKey1, c3po);
    }

    private static String processMessage(String message, int key) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (Character.isUpperCase(chars[i])) {
                    chars[i] = (char) ((chars[i] - 'A' + key) % 26 + 'A');
                } else {
                    chars[i] = (char) ((chars[i] - 'a' + key) % 26 + 'a');
                }
            }
        }
        return new String(chars);
    }
}
