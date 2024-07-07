package faang.school.godbless.BJS29000;

public class Droid {

    public String sendEncryptedMessage(String message, int cipher) {
        return cryptMessage(message, cipher);
    }

    public String receiveEncryptedMessage(String message, int cipher) {
        return cryptMessage(message, -cipher);
    }

    private String cryptMessage(String message, int cipher) {
        DroidMessageEncryptor encryptor = (m, c) -> {
            StringBuilder encrypted = new StringBuilder();
            c = c % 26;
            for (char character : m.toCharArray()) {
                if (character >= 'a' && character <= 'z') {
                    encrypted.append((char) ((character - 'a' + c + 26) % 26 + 'a'));
                } else if (character >= 'A' && character <= 'Z') {
                    encrypted.append((char) ((character - 'A' + c + 26) % 26 + 'A'));
                } else {
                    encrypted.append(character);
                }
            }
            return encrypted.toString();
        };
        return encryptor.encrypt(message, cipher);
    }
}
