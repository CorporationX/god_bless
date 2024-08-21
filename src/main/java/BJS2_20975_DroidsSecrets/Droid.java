package BJS2_20975_DroidsSecrets;

public class Droid {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May tHe forCe be wiTh yOu!";
        int encryptionKey = 3;

        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
        String msg = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);
        System.out.println(encryptedMsg);
        System.out.println(msg);
    }

    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    char encryptedChar = (char) (base + (c - base + k) % 26);
                    encryptedMessage.append(encryptedChar);
                } else {
                    encryptedMessage.append(c);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMessage, int cypherKey) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, key) ->
                sendEncryptedMessage(encryptedMessage, 26 - (cypherKey % 26));
        return droidMessageEncryptor.encrypt(encryptedMessage, cypherKey);
    }
}
