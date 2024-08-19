package faang.school.godbless.DroidsSecrets;

public class Droid {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey,EncryptorMethodName.ENCRYPT);
        String msg = c3po.sendEncryptedMessage(encryptedMsg, encryptionKey,EncryptorMethodName.DECRYPT);

        System.out.println(encryptedMsg);
        System.out.println(msg);
    }

    private final DroidMessageEncryptorOrDecrypt encryptionManager = (message, key, encryptorMethodName) -> {
    key = encryptorMethodName == EncryptorMethodName.ENCRYPT ? key : -key;
    StringBuilder encrypted = new StringBuilder();
    for (char ch : message.toCharArray()) {
        if (Character.isLetter(ch)) {
            char base = Character.isLowerCase(ch) ? 'a' : 'A';
            encrypted.append((char) ((ch - base + key + 26) % 26 + base));
        } else {
            encrypted.append(ch);
        }
    }
    return encrypted.toString();
};

    public String sendEncryptedMessage(String text, int cipherKey, EncryptorMethodName encryptorMethodName) {
        return encryptionManager.transform(text, cipherKey, encryptorMethodName);
    }
}