package faang.school.godbless.BJS29053;

public class Droid {
    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();
        String message = "May the Force be with you!";
        int encryptionKey = 3;

        String encryptedMsg = r2d2.sendEncryptedMessage(message, encryptionKey);
        String msg = c3po.receiveEncryptedMessage(encryptedMsg, encryptionKey);

        System.out.println(encryptedMsg);
        System.out.println(msg);
    }

    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (line, keyEncryptor) -> {
            StringBuilder encryptedLine = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char letter = line.charAt(i);
                char newLetter = (char) (letter + keyEncryptor);
                encryptedLine.append(newLetter);
            }
            return encryptedLine.toString();
        };
        return encryptor.encrypt(message, key);
    }


    public String receiveEncryptedMessage(String message, int key) {
        DroidMessageEncryptor decoder = (line, keyEncryptor) -> {
            StringBuilder encryptedLine = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char letter = line.charAt(i);
                char newLetter = (char) (letter - keyEncryptor);
                encryptedLine.append(newLetter);
            }
            return encryptedLine.toString();
        };
        return decoder.encrypt(message, key);
    }
}
