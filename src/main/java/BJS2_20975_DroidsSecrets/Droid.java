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
        DroidMessageEncryptor droidMessageEncryptor = (msg, key) -> {
            StringBuilder sb = new StringBuilder();
            for (char character : message.toCharArray()) {
                if (Character.isLetter(character)) {
                    char upOrLow = Character.isUpperCase(character) ? 'A' : 'a';
                    int originalPosition = character - upOrLow;
                    int newPosition = (originalPosition + encryptionKey) % 26;
                    char newCharacter = (char) (upOrLow + newPosition);
                    System.out.println(newCharacter);
                    sb.append(newCharacter);
                } else {
                    sb.append(character);
                }
            }
            return sb.toString();
        };
        return droidMessageEncryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMessage, int cypherKey) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, key) ->
                sendEncryptedMessage(encryptedMessage, 26 - (cypherKey % 26));
        return droidMessageEncryptor.encrypt(encryptedMessage, cypherKey);
    }
}
