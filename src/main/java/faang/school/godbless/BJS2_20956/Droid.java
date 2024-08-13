package faang.school.godbless.BJS2_20956;

public class Droid {

    public String sendEncryptedMessage(String message, int encryptKey) {
        DroidMessageEncryptor encryptor = (text, key) -> {
            StringBuilder encryptMessage = new StringBuilder();

            for (Character character : text.toCharArray()) {
                if (Character.isLetter(character)) {
                    char base = Character.isLowerCase(character) ? 'a' : 'A';
                    int offset = character - base;
                    char symbol = (char) ((offset + key + 26) % 26 + base);
                    encryptMessage.append(symbol);
                } else {
                    encryptMessage.append(character);
                }
            }
            return encryptMessage.toString();
        };

        return encryptor.encrypt(message, encryptKey);
    }

    public String receiveEncryptedMessage(String message, int encryptKey) {
        return sendEncryptedMessage(message, -encryptKey);
    }

}
